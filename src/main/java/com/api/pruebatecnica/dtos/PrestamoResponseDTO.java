package com.api.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrestamoResponseDTO {
    private Long id;
    private String isbn;
    private String idUsuario;
    private int tipoUsuario;
    private String fechaMaximaDevolucion;
}
