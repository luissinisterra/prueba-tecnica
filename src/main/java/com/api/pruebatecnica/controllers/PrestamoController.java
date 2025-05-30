package com.api.pruebatecnica.controllers;

import com.api.pruebatecnica.dtos.CreadoResponse;
import com.api.pruebatecnica.dtos.PrestamoRequestDTO;
import com.api.pruebatecnica.services.imp.IPrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/prestamo")
public class PrestamoController {
    private final IPrestamoService prestamoService;

    @PostMapping
    ResponseEntity<CreadoResponse> crearPrestamo(PrestamoRequestDTO prestamoRequestDTO) {
        return ResponseEntity.ok(prestamoService.crearPrestamo(prestamoRequestDTO));
    }
}
