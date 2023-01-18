package com.meta3.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostFormDtoUpdate {

	@NotNull @NotEmpty
	private String mensagem;
}
