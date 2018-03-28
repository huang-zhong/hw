package com.palpay.mq.demo;

import com.palpay.mq.util.JMSProducerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.Destination;

@SpringBootApplication
public class ActiveHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveHelloworldApplication.class, args);
	}
}
