package com.awsDBdemo.db1Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Db1DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(Db1DemoApplication.class, args);
	}

}
