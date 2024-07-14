package com.keatnis.forohub.api.controller;

import com.keatnis.forohub.api.domain.topico.DatosDetalleTopico;
import com.keatnis.forohub.api.domain.topico.DatosRegistroTopico;
import com.keatnis.forohub.api.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico>  registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        var response = service.registrar(datosRegistroTopico);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public String crear() {
        return "hola";
    }
}
