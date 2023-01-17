package com.meta3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meta3.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
