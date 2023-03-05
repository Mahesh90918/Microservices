package com.microServices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microServices.dto.DepartmentDto;

@FeignClient(value = "DEPARTMENT-SERVICE-CIRCUIT-BREAKER")
public interface MyApiClient {
	@GetMapping(value = "/api/departments/{id}")
	DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);
}
