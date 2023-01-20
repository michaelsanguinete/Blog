package com.meta3.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.meta3.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	UserDetails findByLogin(String login);

}
