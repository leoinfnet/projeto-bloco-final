package org.acme.notafiscal_worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NotafiscalWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotafiscalWorkerApplication.class, args);
	}

}