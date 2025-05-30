package com.api.pruebatecnica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String idUsuario;
    private int tipoUsuario;
    private String fechaMaximaDevolucion;

    public Prestamo(String isbn, String idUsuario, int tipoUsuario, String fechaMaximaDevolucion) {
        this.isbn = isbn;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
