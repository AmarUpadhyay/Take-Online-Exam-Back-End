package com.capgemini.toe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TakeOnlineExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeOnlineExamApplication.class, args);
	}

}
