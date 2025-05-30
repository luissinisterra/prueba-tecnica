package com.api.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreadoResponse {
    private Long id;
    private String fechaMaximaDevolucion;
}
