package com.microServices.service;

import com.microServices.dto.ResponseDto;
import com.microServices.entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);

	ResponseDto getUser1(Long userId);
}