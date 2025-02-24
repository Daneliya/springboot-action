package com.xxl.springboot.integration.shiro.service;

import com.xxl.springboot.integration.shiro.vo.Member;

import java.util.Map;
import java.util.Set;

/**
 * @author xxl
 * @date 2025/2/23 23:36
 */
public interface IMemberService {
    public Member get(String mid);

    public Map<String, Set<String>> getRoleAndActionByMember(String mid);
}

