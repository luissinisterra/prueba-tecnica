package com.api.pruebatecnica.services;

import com.api.pruebatecnica.dtos.CreadoResponse;
import com.api.pruebatecnica.dtos.PrestamoRequestDTO;
import com.api.pruebatecnica.dtos.PrestamoResponseDTO;
import com.api.pruebatecnica.entities.Prestamo;
import com.api.pruebatecnica.mappers.PrestamoMapper;
import com.api.pruebatecnica.repositories.IPrestamoRepository;
import com.api.pruebatecnica.services.imp.IPrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrestamoService implements IPrestamoService {
    private final IPrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;

    @Override
    public CreadoResponse crearPrestamo(PrestamoRequestDTO prestamoRequestDTO) throws RuntimeException {

        this.validarInformacion(prestamoRequestDTO);

        LocalDate fechaMaximaDevolucion = LocalDate.now();

        switch (prestamoRequestDTO.getTipoUsuario()){
            case 1:
                fechaMaximaDevolucion = this.obtenerFechaMaximaDevolucion(10);
                break;
            case 2:
                fechaMaximaDevolucion = this.obtenerFechaMaximaDevolucion(8);
                break;
            case 3:
                fechaMaximaDevolucion = this.obtenerFechaMaximaDevolucion(7);

                Optional<Prestamo> prestamoUsuario = prestamoRepository.findByIdUsuario(prestamoRequestDTO.getIdUsuario());

                if (prestamoUsuario.isPresent()) {
                    throw new RuntimeException("El usuario con identificacion " + prestamoRequestDTO.getIdUsuario() + " ya tiene un libro prestamo por lo cual no se le puede realizar otro préstamo.");
                }

                break;
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaMaximaDevolucion.format(formato);

        Prestamo prestamo = new Prestamo(prestamoRequestDTO.getIsbn(), prestamoRequestDTO.getIdUsuario(), prestamoRequestDTO.getTipoUsuario(), fechaFormateada);
        Prestamo nuevoPrestamo = prestamoRepository.save(prestamo);

        return new CreadoResponse(nuevoPrestamo.getId(), fechaFormateada);


        /*if(prestamoRequestDTO.getTipoUsuario() == 1) {
            LocalDate fechaMaximaDevolucion = this.obtenerFechaMaximaDevolucion(10);
            return this.guardarPrestamo(prestamoRequestDTO, fechaMaximaDevolucion);
        }

        if(prestamoRequestDTO.getTipoUsuario() == 2) {
            LocalDate fechaMaximaDevolucion = this.obtenerFechaMaximaDevolucion(8);
             return this.guardarPrestamo(prestamoRequestDTO, fechaMaximaDevolucion);
        }

        if (prestamoRequestDTO.getTipoUsuario() == 3) {
            Optional<Prestamo> prestamoUsuario = prestamoRepository.findByIdUsuario(prestamoRequestDTO.getIdUsuario());

            if (prestamoUsuario.isPresent()) {
                throw new RuntimeException("El usuario con identificacion " + prestamoRequestDTO.getIdUsuario() + " ya tiene un libro prestamo por lo cual no se le puede realizar otro préstamo.");
            }

            LocalDate fechaMaximaDevolucion = this.obtenerFechaMaximaDevolucion(7);
            return this.guardarPrestamo(prestamoRequestDTO, fechaMaximaDevolucion);
        }

        return null;*/
    }

    private void validarInformacion(PrestamoRequestDTO prestamoRequestDTO) throws RuntimeException {
        if (prestamoRequestDTO.getIsbn().length() > 10){
            throw new RuntimeException("El ISBN no puede ser mayor a 10 dígitos.");
        }

        if (prestamoRequestDTO.getIdUsuario().length() > 10){
            throw new RuntimeException("El ID de usuario no puede ser mayor a 10 dígitos.");
        }

        if (prestamoRequestDTO.getTipoUsuario() < 1 || prestamoRequestDTO.getTipoUsuario() > 3){
            throw new RuntimeException("Tipo de usuario no permitido en la biblioteca.");
        }
    }

    private LocalDate obtenerFechaMaximaDevolucion(int diasPrestacion) {
        LocalDate fechaDevolucion = LocalDate.now();

        int diasHabilesContados = 0;
        while (diasHabilesContados < diasPrestacion) {
            fechaDevolucion = fechaDevolucion.plusDays(1);

            DayOfWeek diaDeLaSemana = fechaDevolucion.getDayOfWeek();
            if (diaDeLaSemana != DayOfWeek.SATURDAY && diaDeLaSemana != DayOfWeek.SUNDAY) {
                diasHabilesContados++;
            }
        }

        return fechaDevolucion;
    }

    /*private CreadoResponse guardarPrestamo(PrestamoRequestDTO prestamoRequestDTO, LocalDate fechaMaximaDevolucion) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaMaximaDevolucion.format(formato);

        Prestamo prestamo = new Prestamo(prestamoRequestDTO.getIsbn(), prestamoRequestDTO.getIdUsuario(), prestamoRequestDTO.getTipoUsuario(), fechaFormateada);
        Prestamo nuevoPrestamo = prestamoRepository.save(prestamo);

        return new CreadoResponse(nuevoPrestamo.getId(), fechaFormateada);
    }*/

    @Override
    public PrestamoResponseDTO obtenerPrestamo(Long idPrestamo) throws RuntimeException{
        Optional<Prestamo> prestamo = prestamoRepository.findById(idPrestamo);

        if (prestamo.isEmpty()) {
            throw  new RuntimeException("El prestamo con id " + idPrestamo + " no existe.");
        }

        return this.prestamoMapper.toDTO(prestamo.get());
    }

}
