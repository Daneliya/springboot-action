package com.xxl.springboot.integration.shiro.vo;

import java.io.Serializable;

/**
 * @author xxl
 * @date 2025/2/23 23:37
 */
@SuppressWarnings("serial")
public class Member implements Serializable {
    private String mid;
    private String name;
    private String password;
    private Integer locked;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }
}
