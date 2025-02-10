DROP
DATABASE IF EXISTS xxl_springboot_action ;
CREATE
DATABASE xxl_springboot_action CHARACTER SET UTF8 ;
USE
xxl_springboot_action ;
CREATE TABLE dept
(
    deptno BIGINT AUTO_INCREMENT,
    dname  VARCHAR(50),
    CONSTRAINT pk_deptno PRIMARY KEY (deptno)
);
INSERT INTO dept(dname)
VALUES ('开发部');
INSERT INTO dept(dname)
VALUES ('财务部');
INSERT INTO dept(dname)
VALUES ('市场部');
INSERT INTO dept(dname)
VALUES ('后勤部');
INSERT INTO dept(dname)
VALUES ('公关部');