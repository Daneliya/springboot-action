package com.xxl.springboot.integration.shiro.job;

import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xxl
 * @date 2025/2/23 23:35
 */
public class DefaultQuartzSessionValidationScheduler implements SessionValidationScheduler {

    public static final long DEFAULT_SESSION_VALIDATION_INTERVAL = DefaultSessionManager.DEFAULT_SESSION_VALIDATION_INTERVAL;
    private static final String JOB_NAME = "SessionValidationJob";
    private static final Logger log = LoggerFactory.getLogger(DefaultQuartzSessionValidationJob.class);
    private static final String SESSION_MANAGER_KEY = DefaultQuartzSessionValidationJob.SESSION_MANAGER_KEY;
    private Scheduler scheduler;
    private boolean schedulerImplicitlyCreated = false;

    private boolean enabled = false;
    private ValidatingSessionManager sessionManager;
    private long sessionValidationInterval = DEFAULT_SESSION_VALIDATION_INTERVAL;

    public DefaultQuartzSessionValidationScheduler() {
    }

    public DefaultQuartzSessionValidationScheduler(ValidatingSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    protected Scheduler getScheduler() throws SchedulerException {
        if (this.scheduler == null) {
            this.scheduler = StdSchedulerFactory.getDefaultScheduler();
            this.schedulerImplicitlyCreated = true;
        }
        return this.scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setSessionManager(ValidatingSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setSessionValidationInterval(long sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }

    public void enableSessionValidation() {
        if (log.isDebugEnabled()) {
            log.debug("Scheduling session validation job using Quartz with session validation interval of ["
                    + this.sessionValidationInterval + "]ms...");
        }

        try {
            SimpleTrigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity(JOB_NAME, Scheduler.DEFAULT_GROUP)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(sessionValidationInterval))
                    .build();//<span style="color:#ff0000;">Quartz 2中的实现</span>

            JobDetail detail = JobBuilder.newJob(DefaultQuartzSessionValidationJob.class)
                    .withIdentity(JOB_NAME, Scheduler.DEFAULT_GROUP).build();
            detail.getJobDataMap().put(SESSION_MANAGER_KEY, this.sessionManager);
            Scheduler scheduler = getScheduler();

            scheduler.scheduleJob(detail, trigger);
            if (this.schedulerImplicitlyCreated) {
                scheduler.start();
                if (log.isDebugEnabled()) {
                    log.debug("Successfully started implicitly created Quartz Scheduler instance.");
                }
            }
            this.enabled = true;

            if (log.isDebugEnabled())
                log.debug("Session validation job successfully scheduled with Quartz.");
        } catch (SchedulerException e) {
            if (log.isErrorEnabled())
                log.error("Error starting the Quartz session validation job.  Session validation may not occur.", e);
        }
    }

    public void disableSessionValidation() {
        if (log.isDebugEnabled()) {
            log.debug("Stopping Quartz session validation job...");
        }
        Scheduler scheduler;
        try {
            scheduler = getScheduler();
            if (scheduler == null) {
                if (log.isWarnEnabled()) {
                    log.warn("getScheduler() method returned a null Quartz scheduler, which is unexpected.  Please check your configuration and/or implementation.  Returning quietly since there is no validation job to remove (scheduler does not exist).");
                }

                return;
            }
        } catch (SchedulerException e) {
            if (log.isWarnEnabled()) {
                log.warn("Unable to acquire Quartz Scheduler.  Ignoring and returning (already stopped?)", e);
            }
            return;
        }
        try {
            scheduler.unscheduleJob(new TriggerKey("SessionValidationJob", "DEFAULT"));
            if (log.isDebugEnabled())
                log.debug("Quartz session validation job stopped successfully.");
        } catch (SchedulerException e) {
            if (log.isDebugEnabled()) {
                log.debug("Could not cleanly remove SessionValidationJob from Quartz scheduler.  Ignoring and stopping.", e);
            }

        }

        this.enabled = false;

        if (this.schedulerImplicitlyCreated)
            try {
                scheduler.shutdown();
            } catch (SchedulerException e) {
                if (log.isWarnEnabled())
                    log.warn("Unable to cleanly shutdown implicitly created Quartz Scheduler instance.", e);
            } finally {
                setScheduler(null);
                this.schedulerImplicitlyCreated = false;
            }
    }

}

