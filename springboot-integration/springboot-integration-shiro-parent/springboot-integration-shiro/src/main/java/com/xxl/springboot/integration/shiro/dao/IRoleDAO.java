package com.xxl.springboot.integration.shiro.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author xxl
 * @date 2025/2/23 23:40
 */
@Mapper
public interface IRoleDAO {
    public Set<String> findAllRoleByMember(String mid) ;
}
