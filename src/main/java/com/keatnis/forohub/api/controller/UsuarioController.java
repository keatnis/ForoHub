package com.keatnis.forohub.api.controller;

import com.keatnis.forohub.api.domain.topico.DatosListadoTopico;
import com.keatnis.forohub.api.domain.usuario.DatosDetalleUsuario;
import com.keatnis.forohub.api.domain.usuario.DatosRegistrarUsuario;
import com.keatnis.forohub.api.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

        @PostMapping
        @Transactional
        public ResponseEntity<DatosDetalleUsuario> registrar(@RequestBody @Valid DatosRegistrarUsuario datos){
            var response = service.guardarUser(datos);
            return ResponseEntity.ok(response);
        }

        @GetMapping
    public ResponseEntity<Page<DatosDetalleUsuario>> listaUsuarios(@PageableDefault(size = 10) Pageable pagination){
        var response = service.getUsuarios(pagination);
        return ResponseEntity.ok(response);
        }
}
