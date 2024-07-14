package com.keatnis.forohub.api.domain.topico;

import com.keatnis.forohub.api.domain.curso.CursoRepository;
import com.keatnis.forohub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public DatosDetalleTopico registrar(DatosRegistroTopico datosRegistroTopico) {
        var topico = new Topico(datosRegistroTopico);
        var usuario = usuarioRepository.getReferenceById(datosRegistroTopico.idUsuario());
        var curso = cursoRepository.getReferenceById(datosRegistroTopico.idCurso());
        //asignamos el usuario y el curso dependiendo del id proporcionado por el cliente
        topico.setUsuario(usuario);
        topico.setCurso(curso);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }

    public Page<DatosListadoTopico> getAllTopicos(Pageable pageable) {
        return topicoRepository.findAll(pageable).map(DatosListadoTopico::new);
    }
}
