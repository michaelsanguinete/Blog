package com.meta3.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDeFormularioDTO {

    private String campo;

    private String erro;
    
}

