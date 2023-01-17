package com.meta3.demo.dto;

import java.util.Date;

import com.meta3.demo.entity.User;

import lombok.Data;

@Data
public class PostDto {

    private String mensagem;
	private User autor;
	private Date dataCriacao;
	private Date dataAlteracao;
    
}
