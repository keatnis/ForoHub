package com.keatnis.forohub.api.controller;

import com.keatnis.forohub.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoService service;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico> registarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        var response = service.registrar(datosRegistroTopico);
        //crearmos url para visualizar ls datos del registro
        URI urlTopico = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(urlTopico).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10, sort = "titulo") Pageable pageable) {
        var response = service.getAllTopicos(pageable);
        System.out.println(response.get());
        return ResponseEntity.ok(response);
    }
}
