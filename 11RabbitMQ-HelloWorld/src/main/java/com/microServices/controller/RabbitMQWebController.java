package com.microServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microServices.messageSender.RabbitMQSender;
import com.microServices.model.Employee;

@RestController
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@PostMapping(value = "/producer")
	public String producer(@RequestBody Employee emp) {
	
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

}
