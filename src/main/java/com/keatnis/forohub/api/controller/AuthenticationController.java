package com.keatnis.forohub.api.controller;

import com.keatnis.forohub.api.domain.usuario.DatosAuthUsuario;
import com.keatnis.forohub.api.domain.usuario.UsuarioService;
import com.keatnis.forohub.api.infra.security.DatosJWTToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private UsuarioService usuarioService;
    //metodo para autenticar el usario proporcionado y se genera un token para realizar solicitudes al api
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAuthUsuario datosAutenticacionUsuario) {
        var response = usuarioService.autenticarUsuario(datosAutenticacionUsuario);
        return ResponseEntity.ok(new DatosJWTToken(response));
    }

}
