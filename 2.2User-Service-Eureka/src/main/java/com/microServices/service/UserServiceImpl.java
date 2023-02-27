package com.microServices.service;

import static org.springframework.beans.BeanUtils.copyProperties;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microServices.dto.DepartmentDto;
import com.microServices.dto.ResponseDto;
import com.microServices.dto.UserDto;
import com.microServices.entity.User;
import com.microServices.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

// All arg constructor we donot wont to Need @autoWire Annotation

	private UserRepository userRepository;
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) {
		ResponseDto responseDto = new ResponseDto();
		User user = userRepository.findById(userId).get();
		UserDto userDto = mappedByUser(user);

		String getDeptUrl="http://DEPARTMENT-SERVICE-CLIENT/api/departments/"+user.getDepartmentId();
		
		ResponseEntity<DepartmentDto> deptDto=restTemplate.getForEntity(getDeptUrl, DepartmentDto.class);
		DepartmentDto departmentDto = deptDto.getBody();
		
		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);

		return responseDto;
	}

	private UserDto mappedByUser(User user) {
		UserDto mapUesrDto = new UserDto();
		mapUesrDto.setId(user.getId());
		mapUesrDto.setFirstName(user.getFirstName());
		mapUesrDto.setLastName(user.getLastName());
		mapUesrDto.setEmail(user.getEmail());
		return mapUesrDto;
	}
	
	public ResponseDto getUser1(Long userId) {
		ResponseDto responseDto = new ResponseDto();
		User user = userRepository.findById(userId).get();
		UserDto userDto =new UserDto() ;
		// Second Way
		// its Available in Builder
		copyProperties(user, userDto);

		String getDeptUrl="http://localhost:9091/api/departments/"+user.getDepartmentId();
		
		ResponseEntity<DepartmentDto> deptDto=restTemplate.getForEntity(getDeptUrl, DepartmentDto.class);
		DepartmentDto departmentDto = deptDto.getBody();
		
		responseDto.setDepartment(departmentDto);
		responseDto.setUser(userDto);

		return responseDto;
	}
}