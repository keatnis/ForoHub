package com.keatnis.forohub.api.domain.topico;

import com.keatnis.forohub.api.domain.curso.CursoRepository;
import com.keatnis.forohub.api.domain.usuario.UsuarioRepository;
import com.keatnis.forohub.api.infra.errores.ErrorHandlerConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public DatosDetalleTopico buscarPorId(Long id) {
        //buscamos si existe el topico por el id
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return new DatosDetalleTopico(topico.get());
        } else {
            // throw new ErrorHandlerConsultas("debe proporciona un id");
            throw new ErrorHandlerConsultas("El ID no existe en la base de datos");
        }
    }

    public DatosDetalleTopico actualizarTopico(Long id, DatosActualizarTopico datosActualizarTopico) {
        Optional<Topico> topicoExiste = topicoRepository.findById(id);

        if (topicoExiste.isPresent()) {
            Topico topico = topicoExiste.get();
            topico.actualizar(datosActualizarTopico);
            return new DatosDetalleTopico(topico);
        } else {
            throw new ErrorHandlerConsultas("El ID del topico NO existe/no es valido");
        }
    }

    public void eliminar(Long id) {
        if (id == null) {
            throw new ErrorHandlerConsultas("Error: el ID proporcionacio es null");
        }

        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            // varficamos si el topico existe en la base de datos, para eliminarlo
            topicoRepository.deleteById(id);
        } else {
            throw new ErrorHandlerConsultas("El ID del topico NO existe en la base de datos");
        }

    }
}
