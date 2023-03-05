package com.microServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microServices.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}