package com.yf.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.yf.spring.spring.bean.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@SuppressWarnings("all")
    public static void main( String[] args )
    {
        ApplicationContext ioc=new AnnotationConfigApplicationContext(Config.class);
        Student student = ioc.getBean(Student.class);
        student.say();
        
    }
}

class Config{
	
	@Bean
	public Student student() {
		return new Student();
	}
	
}
