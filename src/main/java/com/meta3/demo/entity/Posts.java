package com.meta3.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Posts {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mensagem;
	@ManyToOne
	private User autor;
	private LocalDateTime dataCriacao =  LocalDateTime.now();
	private LocalDateTime dataAlteracao;
}
