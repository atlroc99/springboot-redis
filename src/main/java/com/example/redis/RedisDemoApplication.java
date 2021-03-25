package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class RedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
		Arrays.stream(beanDefinitionNames).forEach(System.out::println);
	}

}
