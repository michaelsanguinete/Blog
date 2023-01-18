package com.meta3.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meta3.demo.dto.DetalhesPostDto;
import com.meta3.demo.dto.PostDto;
import com.meta3.demo.dto.PostFormDto;
import com.meta3.demo.dto.PostFormDtoUpdate;
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
        post.setDataAlteracao(LocalDateTime.now());
        post.setAutor(user);

        this.postsRepository.save(post);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    public ResponseEntity<?> delete (int id){
    	
    	Optional<Posts> optional = postsRepository.findById(id);
    	if (optional.isPresent()) {
    		postsRepository.deleteById(id);
    		return ResponseEntity.ok().build();
    	}
    	return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PostDto> update (int id, PostFormDtoUpdate formDto){
    	
    	Optional<Posts> post = postsRepository.findById(id);
    	if (post.isPresent()) {
    		post.get().setMensagem(formDto.getMensagem());
    		post.get().setDataAlteracao(LocalDateTime.now());
    		post.get().getAutor().setNome(post.get().getAutor().getNome()); 
    		return ResponseEntity.ok().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
    public ResponseEntity<List<DetalhesPostDto>> list (String nome){
    	
        if (nome == null){
       
            List<Posts> posts = postsRepository.findAll();
    	
    	    List<DetalhesPostDto> postsDto = new ArrayList<>();
    	
    	    posts.forEach(de -> postsDto.add(new DetalhesPostDto(de)));
    	
    	    return ResponseEntity.ok(postsDto);
        }
        else {
            List<Posts> posts = postsRepository.findByAutor_Nome(nome);
    	
    	    List<DetalhesPostDto> postsDto = new ArrayList<>();
    	
    	    posts.forEach(de -> postsDto.add(new DetalhesPostDto(de)));
    	
    	    return ResponseEntity.ok(postsDto);
        }
    	
    }

    public ResponseEntity<PostDto> getPost (int id){

        Optional<Posts> optional = postsRepository.findById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(modelMapper.map(optional.get(), PostDto.class));
        }
        return ResponseEntity.notFound().build();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}



































