package com.meta3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meta3.demo.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

}
