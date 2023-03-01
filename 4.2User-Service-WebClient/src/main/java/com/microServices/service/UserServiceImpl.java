package com.microServices.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

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
//	private RestTemplate restTemplate;

	private WebClient webClient;

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

		String getDeptUrl = "http://localhost:1111/api/departments/" + user.getDepartmentId();
		DepartmentDto departmentDto = webClient.get().uri(getDeptUrl).retrieve().bodyToMono(DepartmentDto.class)
				.block();
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

}