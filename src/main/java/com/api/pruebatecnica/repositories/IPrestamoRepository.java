package com.api.pruebatecnica.repositories;

import com.api.pruebatecnica.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
    Optional<Prestamo> findByIdUsuario(String idUsuario);
}
