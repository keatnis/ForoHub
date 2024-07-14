package com.keatnis.forohub.api.controller;

import com.keatnis.forohub.api.domain.curso.CursoService;
import com.keatnis.forohub.api.domain.curso.DatosDetalleCurso;
import com.keatnis.forohub.api.domain.curso.DatosRegistroCurso;
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
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                            UriComponentsBuilder uriComponentsBuilder) {
        var response = service.registar(datosRegistroCurso);
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleCurso>> listadoCursos(@PageableDefault(size = 10) Pageable pageable) {
        var response = service.obtenerCursos(pageable);
        return ResponseEntity.ok(response);
    }

}
