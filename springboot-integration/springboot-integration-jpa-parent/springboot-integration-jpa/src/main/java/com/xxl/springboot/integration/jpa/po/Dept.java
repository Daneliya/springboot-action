package com.xxl.springboot.integration.jpa.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xxl
 * @date 2025/2/15 21:10
 */
@Table(name = "dept")
@SuppressWarnings("serial")
@Cacheable(true)
@Entity
public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
    private Long deptno; // 字段的映射（属性名称=字段名称）
    @Column()
    private String dname;

    // setter、getter略
    public Dept() {
    }

    public Long getDeptno() {
        return this.deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }


    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}