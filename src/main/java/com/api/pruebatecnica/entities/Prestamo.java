package com.api.pruebatecnica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long isbn;
    private String idUsuario;
    private int tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

    public Prestamo(Long isbn, String idUsuario, int tipoUsuario) {
        this.isbn = isbn;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
    }
}
