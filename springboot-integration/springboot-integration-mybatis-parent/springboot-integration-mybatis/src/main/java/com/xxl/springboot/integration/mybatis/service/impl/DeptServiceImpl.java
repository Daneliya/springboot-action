package com.xxl.springboot.integration.mybatis.service.impl;

import com.xxl.springboot.integration.mybatis.dao.IDeptDAO;
import com.xxl.springboot.integration.mybatis.service.IDeptService;
import com.xxl.springboot.integration.mybatis.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxl
 * @date 2025/2/11 0:02
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll();
    }

}
