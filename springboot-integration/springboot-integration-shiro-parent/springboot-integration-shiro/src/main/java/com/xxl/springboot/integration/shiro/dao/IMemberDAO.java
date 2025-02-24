package com.xxl.springboot.integration.shiro.dao;

import com.xxl.springboot.integration.shiro.vo.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xxl
 * @date 2025/2/23 23:39
 */
@Mapper
public interface IMemberDAO {
    public Member findById(String mid) ;
}

