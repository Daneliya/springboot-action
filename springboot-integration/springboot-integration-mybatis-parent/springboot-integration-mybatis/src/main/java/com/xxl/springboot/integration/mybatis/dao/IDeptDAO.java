package com.xxl.springboot.integration.mybatis.dao;

import com.xxl.springboot.integration.mybatis.vo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xxl
 * @date 2025/2/11 0:00
 */
@Mapper
public interface IDeptDAO {

    /**
     * 查询全部部门信息
     *
     * @return
     */
    @Select("SELECT deptno,dname FROM dept")
    public List<Dept> findAll();

}
