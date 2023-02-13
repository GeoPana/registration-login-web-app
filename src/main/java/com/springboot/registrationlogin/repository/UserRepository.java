package com.springboot.registrationlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.registrationlogin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String Email);
}
