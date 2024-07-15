package com.keatnis.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank(message = "el titulo no debe de estar en blanco")
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull(message = "la fecha de creacion no debe de estar vacia")
//        LocalDateTime fechaCreacion,
//        @NotNull(message = "el id del curso no debe de estar en blanco")
        Long idCurso,
        @NotNull(message = "proporcio el id del usuario, no debe estar vacion")
        Long idUsuario
) {
}
