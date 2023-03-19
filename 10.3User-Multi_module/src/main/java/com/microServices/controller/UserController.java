package com.microServices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microServices.dto.ResponseDto;
import com.microServices.entity.User;
import com.microServices.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("api/users")
//@AllArgsConstructor

public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	@Lazy
    private UserService userService;

    private  static final  String DEPT_SERVICE="myProjectAllRemotecallsDepartMent";
    
    @Value("${spring.application.name}")
	private String applicationName;

    
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
    	logger.info("Request at {} for request /id ", applicationName);
    	logger.info("Request at {} for request /id ", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
   
    @GetMapping("{id}")
    @CircuitBreaker(name =DEPT_SERVICE ,fallbackMethod = "getApiFallBack")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId){
       
    	logger.info("Request at {} for request /id ", applicationName);
    	
    	ResponseDto responseDto = userService.getUser(userId);
    	logger.info("Request at {} for request /id ", responseDto);
        return ResponseEntity.ok(responseDto);
    }
    
    // both return Types are Equal Must
    public ResponseEntity<?>  getApiFallBack(Exception ex) {
		return new ResponseEntity("Error : Department Service is Down",HttpStatus.OK);
    	
    }
    
  
}