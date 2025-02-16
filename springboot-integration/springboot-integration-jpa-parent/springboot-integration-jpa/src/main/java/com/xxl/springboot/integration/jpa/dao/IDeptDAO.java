package com.xxl.springboot.integration.jpa.dao;

import com.xxl.springboot.integration.jpa.po.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xxl
 * @date 2025/2/15 21:11
 */
public interface IDeptDAO extends JpaRepository<Dept, Long> { // 包含有全部的基础Crud支持
}