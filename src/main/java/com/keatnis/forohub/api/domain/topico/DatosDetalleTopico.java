package com.keatnis.forohub.api.domain.topico;

import com.keatnis.forohub.api.domain.curso.DatosDetalleCurso;
import com.keatnis.forohub.api.domain.usuario.DatosDetalleUsuario;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        DatosDetalleUsuario autor,
        DatosDetalleCurso curso

) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                new DatosDetalleUsuario(topico.getUsuario()), new DatosDetalleCurso(topico.getCurso()));
    }
}
