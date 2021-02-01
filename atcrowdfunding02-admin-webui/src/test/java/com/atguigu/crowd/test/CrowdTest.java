package com.atguigu.crowd.test;

import entity.Admin;
import entity.Role;
import mapper.AdminMapper;
import mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.api.AdminService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testRoleSave(){
        for(int i = 0; i<235; i++){
            roleMapper.insert(new Role(null,"role"+i));
        }
    }



    @Test
    public void test(){
        for(int i = 0; i<238; i++){
            adminMapper.insert(new Admin(null,"loginAcct"+i,"userPswd"+i,"userName"+i,"email"+i,null));
        }
    }

    @Test
    public void testTx(){
        Admin admin = new Admin(null,"jerry","12345","杰瑞","jerry@qq.com",null);
        adminService.saveAdmin(admin);
    }


    @Test
    public void testLog(){
        //1.获取logger对象
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        //2.根据不同日志级别打印日志
        logger.debug("Hello,I'm debug level");
        logger.info("hello,I'm info level");
        logger.warn("warn level");
        logger.error("error level");

    }

    @Test
    public void testInsertAdmin(){
       Admin admin =  new Admin(null,"tom","123", "汤姆","tom@qq.com",null);
       int count = adminMapper.insert(admin);
       System.out.println(count);
    }
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println((connection));

    }



}
