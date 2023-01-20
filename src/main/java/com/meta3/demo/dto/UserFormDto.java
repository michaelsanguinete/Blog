package com.meta3.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserFormDto {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String login;
	@NotNull @NotEmpty @Length(min = 6, max = 16)
	private String senha;
}
