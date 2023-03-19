package com.microServices.messageSender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microServices.model.Employee;
import com.microServices.rabitMqConfig.RabbitMQConfig;

@Service
public class RabbitMQSender {
//	procedure
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(Employee company) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.exchange, RabbitMQConfig.routingkey, company);
		System.out.println("Send msg = " + company);

	}
}