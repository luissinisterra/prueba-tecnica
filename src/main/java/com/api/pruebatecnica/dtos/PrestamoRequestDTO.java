package com.api.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrestamoRequestDTO {
    private String isbn;
    private String idUsuario;
    private int tipoUsuario;
}
