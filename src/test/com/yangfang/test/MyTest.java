package com.yangfang.test;

import com.yf.spring.spring.config.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import java.util.List;
import java.util.Map;

/**
 * @author yang fang
 * @version 0.0.1
 * @date 2019-08-06 14:30
 */
public class MyTest {

    private JdbcTemplate jdbcTemplate;

    private ApplicationContext ioc;

    @Before
    public void before(){
        ioc=new AnnotationConfigApplicationContext(Configuration.class);
        jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    }

    @After
    public void after(){
        //do nothing
    }

    @Test
    public void testAll(){
        String sql="select * from dept";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
    }

    @Test
    public void queryOne(){
        String sql="select * from dept where id =1";
        Object object = jdbcTemplate.queryForObject(sql, new SingleColumnRowMapper<>());
        System.out.println(object);
    }


}
