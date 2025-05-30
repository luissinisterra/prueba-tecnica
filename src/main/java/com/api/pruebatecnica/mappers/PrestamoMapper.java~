package com.api.pruebatecnica.mappers;

import com.api.pruebatecnica.dtos.PrestamoRequestDTO;
import com.api.pruebatecnica.dtos.PrestamoResponseDTO;
import com.api.pruebatecnica.entities.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

    PrestamoResponseDTO toDTO(Prestamo prestamo);

    @Mapping(target = "id", ignore = true)
    Prestamo toEntity(PrestamoRequestDTO prestamoRequestDTO);
}
