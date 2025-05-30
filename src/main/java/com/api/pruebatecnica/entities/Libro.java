package com.api.pruebatecnica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Libro {
    @Id
    private Integer isbn;
    private String titulo;
    private String autor;
}
