package com.microServices.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microServices.model.Employee;
import com.microServices.rabitMqConfig.RabbitMQConfig;

@Component
public class EmployeeConsume {

	@RabbitListener(queues = RabbitMQConfig.queueName)
	public void messageconsume(Employee employee) {
		System.out.println("message from employee queue"+employee);
	}
}
