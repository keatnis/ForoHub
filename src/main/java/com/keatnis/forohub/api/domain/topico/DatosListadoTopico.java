package com.keatnis.forohub.api.domain.topico;

import com.keatnis.forohub.api.domain.curso.DatosDetalleCurso;
import com.keatnis.forohub.api.domain.usuario.DatosDetalleUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        DatosDetalleUsuario autor,
        DatosDetalleCurso curso

) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), new DatosDetalleUsuario(topico.getUsuario()), new DatosDetalleCurso(topico.getCurso()));
    }
}
