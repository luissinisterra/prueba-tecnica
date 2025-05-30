package com.api.pruebatecnica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String tipoUsuario;
}
