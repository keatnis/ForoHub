package com.keatnis.forohub.api.domain.usuario;


import com.keatnis.forohub.api.domain.topico.DatosListadoTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public DatosDetalleUsuario guardarUser(DatosRegistrarUsuario datos) {

       // var perfilUser = perfilRepository.getReferenceById(datos.IdPerfil());
        var usuario  = new Usuario(datos);
        repository.save(usuario);
        return new DatosDetalleUsuario(usuario);

    }

    public Page<DatosDetalleUsuario> getUsuarios(Pageable pagination) {
        return repository.findAll(pagination).map(DatosDetalleUsuario::new);
    }

}
