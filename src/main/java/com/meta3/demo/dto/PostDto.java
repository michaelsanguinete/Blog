package com.meta3.demo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PostDto {

    private String mensagem;
	private UserDto autor;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataCriacao;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataAlteracao;
    
}
