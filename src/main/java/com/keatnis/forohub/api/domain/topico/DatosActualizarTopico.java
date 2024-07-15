package com.keatnis.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        String titulo,
        String mensaje
  //      LocalDateTime fechaCreacion
//        Long idCurso,
//        Long idUsuario
) {
}
