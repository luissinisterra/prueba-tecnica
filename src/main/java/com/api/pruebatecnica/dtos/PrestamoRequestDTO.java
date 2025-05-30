package com.api.pruebatecnica.dtos;

import lombok.Data;

@Data
public class PrestamoRequestDTO {
    private Long isbn;
    private String idUsuario;
    private int tipoUsuario;
}
