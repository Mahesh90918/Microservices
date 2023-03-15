package com.microServices.jwtToken;

import java.util.Map;

import com.microServices.model.User;

public interface JwtGeneratorInterface {
	public Map<String, String> generateToken(User user);
}
