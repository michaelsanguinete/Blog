package com.meta3.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meta3.demo.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

    List<Posts> findByAutor_Nome(String nomeAutor);

}
