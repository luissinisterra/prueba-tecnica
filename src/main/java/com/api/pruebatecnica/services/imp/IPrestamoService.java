package com.api.pruebatecnica.services.imp;

import com.api.pruebatecnica.dtos.CreadoResponse;
import com.api.pruebatecnica.dtos.PrestamoRequestDTO;

public interface IPrestamoService {
    CreadoResponse crearPrestamo(PrestamoRequestDTO prestamoRequestDTO);

}
