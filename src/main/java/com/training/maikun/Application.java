package com.training.maikun;

import com.training.maikun.result.ResultServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @program: order
 * @Description: main method of application
 * @author: Mr.Cheng
 * @date: 2018/7/29 上午12:50
 */
@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public ResultServiceImpl resultService(){
//		return new ResultServiceImpl();
//	}
}
