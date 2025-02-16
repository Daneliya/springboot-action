package com.xxl.springboot.integration.transactional.service.impl;

import com.xxl.springboot.integration.transactional.dao.IDeptDAO;
import com.xxl.springboot.integration.transactional.service.IDeptService;
import com.xxl.springboot.integration.transactional.vo.Dept;
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

    @Override
    public boolean addDept(String deptName) {
        int result = this.deptDAO.addDept(deptName);
        if (result > 0) {
            // 自定义异常测试
            int i = 1 / 0;
            return true;
        }
        return false;
    }

}
