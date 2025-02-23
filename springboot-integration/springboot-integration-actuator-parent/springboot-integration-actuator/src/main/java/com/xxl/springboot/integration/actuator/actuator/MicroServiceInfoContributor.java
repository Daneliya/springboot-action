package com.xxl.springboot.integration.actuator.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author xxl
 * @date 2025/2/23 22:16
 */
@Component
public class MicroServiceInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("company.name", "https://luckilyxxl.xyz") ;
        builder.withDetail("version", "V1.0") ;
        builder.withDetail("author", "xxl") ;
    }
}
