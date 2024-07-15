package com.keatnis.forohub.api.domain.usuario;


import com.keatnis.forohub.api.domain.topico.DatosListadoTopico;
import com.keatnis.forohub.api.infra.errores.ErrorHandlerConsultas;
import com.keatnis.forohub.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public DatosDetalleUsuario guardarUser(DatosRegistrarUsuario datos) {

        // var perfilUser = perfilRepository.getReferenceById(datos.IdPerfil());
        var usuario = new Usuario(datos);
        usuario.setPassword(passwordEncoder.encode(datos.password()));
        repository.save(usuario);
        return new DatosDetalleUsuario(usuario);

    }

    public Page<DatosDetalleUsuario> getUsuarios(Pageable pagination) {
        return repository.findAll(pagination).map(DatosDetalleUsuario::new);
    }

    public String autenticarUsuario(DatosAuthUsuario datosAuthUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAuthUsuario.username(),
                datosAuthUsuario.password());
        if (!authToken.isAuthenticated()) {
            throw new ErrorHandlerConsultas("verifique sus credenciales");
        }
        var userAuth = authenticationManager.authenticate(authToken);
        return tokenService.generarToken((Usuario) userAuth.getPrincipal());
    }
}
