package com.keatnis.forohub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDetalleCurso(
        Long id,
        String nombre,
        Categoria categoria
) {
    public DatosDetalleCurso(Curso curso) {
        this(curso.getId(),curso.getNombre(),curso.getCategoria());
    }
}
