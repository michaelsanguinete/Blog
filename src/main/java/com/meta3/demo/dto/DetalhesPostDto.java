package com.meta3.demo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meta3.demo.entity.Posts;

import lombok.Data;

@Data
public class DetalhesPostDto {
	
	private int id;
	private String mensagem;
	private String autor;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataCriacao;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataAlteracao;
	
	public DetalhesPostDto (Posts posts) {
		this.id = posts.getId();
		this.mensagem = posts.getMensagem();
		this.autor = posts.getAutor().getNome();
		this.dataCriacao = posts.getDataCriacao();
		this.dataAlteracao = posts.getDataAlteracao();
	}

}
