package com.xxl.springboot.integration.shiro.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author xxl
 * @date 2025/2/23 23:39
 */
@Mapper
public interface IActionDAO {
    public Set<String> findAllActionByMember(String mid) ;
}