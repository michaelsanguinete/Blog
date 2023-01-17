package com.meta3.demo.service;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meta3.demo.dto.PostDto;
import com.meta3.demo.dto.PostFormDto;
import com.meta3.demo.entity.Posts;
import com.meta3.demo.entity.User;
import com.meta3.demo.repository.PostsRepository;
import com.meta3.demo.repository.UserRepository;

@Service
public class PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostsRepository postsRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<PostDto> save (PostFormDto formDto){

        User user = this.userRepository.getReferenceById(formDto.getAutor());
        Posts post = modelMapper.map(formDto, Posts.class);
        post.setDataCriacao(new Date());
        post.setDataAlteracao(new Date());
        post.setAutor(user);

        this.postsRepository.save(post);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    
}
