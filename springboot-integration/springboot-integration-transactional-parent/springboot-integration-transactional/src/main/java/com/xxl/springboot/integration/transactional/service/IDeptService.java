package com.xxl.springboot.integration.transactional.service;

import com.xxl.springboot.integration.transactional.vo.Dept;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxl
 * @date 2025/2/11 0:02
 */
public interface IDeptService {

//    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Dept> list();

//    @Transactional(rollbackFor = Exception.class)
    public boolean addDept(String deptName);
}

