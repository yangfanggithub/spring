package com.yf.spring.spring.config;

import com.yf.spring.spring.bean.Student;
import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author yang fang
 * @version 0.0.1
 * @date 2019-08-06 12:13
 */
@PropertySource("classpath:db.properties")
public class Configuration {

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(@Value("${url}") String url, @Value("${pwd}")String password, @Value("${driver}") String driver, @Value("${user}") String user){
        return new DriverDataSource(url,driver,new Properties(),user,password);
    }

}
