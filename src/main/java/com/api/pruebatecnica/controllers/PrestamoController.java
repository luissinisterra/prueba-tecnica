package com.api.pruebatecnica.controllers;

import com.api.pruebatecnica.dtos.CreadoResponse;
import com.api.pruebatecnica.dtos.PrestamoRequestDTO;
import com.api.pruebatecnica.dtos.PrestamoResponseDTO;
import com.api.pruebatecnica.services.imp.IPrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/prestamo")
public class PrestamoController {
    private final IPrestamoService prestamoService;

    @PostMapping
    ResponseEntity<CreadoResponse> crearPrestamo(@RequestBody PrestamoRequestDTO prestamoRequestDTO) throws RuntimeException {
        CreadoResponse creadoResponse = this.prestamoService.crearPrestamo(prestamoRequestDTO);
        return ResponseEntity.ok(creadoResponse);
    }

    @GetMapping("/{idPrestamo}")
    ResponseEntity<PrestamoResponseDTO> obtenerPrestamo(@PathVariable Long idPrestamo) throws RuntimeException {
        PrestamoResponseDTO prestamoResponseDTO = this.prestamoService.obtenerPrestamo(idPrestamo);
        return ResponseEntity.ok(prestamoResponseDTO);
    }
}
