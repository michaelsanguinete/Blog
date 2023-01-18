package com.meta3.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostFormDto {
    
    @NotNull @NotEmpty
    private String mensagem;
    @NotNull
    private int autor;

}
