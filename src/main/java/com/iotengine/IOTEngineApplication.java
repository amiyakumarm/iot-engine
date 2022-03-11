package com.iotengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IOTEngineApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IOTEngineApplication.class, args);
		TestApp app = context.getBean(TestApp.class);
		app.doExecute();

	}

}
