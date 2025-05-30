package com.api.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreadoResponse {
    private Long id;
    private LocalDate fechaMaximaDevolucion;
}
