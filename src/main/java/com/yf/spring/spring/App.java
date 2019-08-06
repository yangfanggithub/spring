package com.yf.spring.spring;

import com.yf.spring.spring.config.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@SuppressWarnings("all")
    public static void main( String[] args )
    {
        String sql="select * from dept";
        ApplicationContext ioc=new AnnotationConfigApplicationContext(Configuration.class);
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);

    }
}
