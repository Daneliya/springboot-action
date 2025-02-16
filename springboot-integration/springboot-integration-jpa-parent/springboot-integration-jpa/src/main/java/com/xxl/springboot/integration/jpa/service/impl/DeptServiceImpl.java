package com.xxl.springboot.integration.jpa.service.impl;

import com.xxl.springboot.integration.jpa.dao.IDeptDAO;
import com.xxl.springboot.integration.jpa.po.Dept;
import com.xxl.springboot.integration.jpa.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxl
 * @date 2025/2/15 21:12
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDAO deptDAO ;
    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll() ;
    }

}
