package com.meta3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meta3.demo.dto.PostDto;
import com.meta3.demo.dto.PostFormDto;
import com.meta3.demo.service.PostService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    @Transactional
    public ResponseEntity<PostDto> save (@Valid @RequestBody PostFormDto formDto){
        return this.service.save(formDto);
    }
    
}
