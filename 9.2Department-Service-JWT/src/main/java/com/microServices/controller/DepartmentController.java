package com.microServices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microServices.entity.Department;
import com.microServices.repository.DepartmentRepository;
import com.microServices.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentRepository dep;

	@Value("${spring.application.name}")
	private String applicationName;

	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("Request at {} for request /id ", applicationName);
		System.out.println("Department ID:" + departmentId);
		Department department = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(department);
	}
	@GetMapping("/getAll")
	public List<Department> findAll(){
		return dep.findAll();
		
	}
	
}