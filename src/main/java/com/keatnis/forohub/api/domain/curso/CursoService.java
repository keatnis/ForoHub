package com.keatnis.forohub.api.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public DatosDetalleCurso registar(DatosRegistroCurso datos) {
        var curso = new Curso(datos);
        repository.save(curso);
        return new DatosDetalleCurso(curso);
    }

    public Page<DatosDetalleCurso> obtenerCursos(Pageable pageable) {
        return repository.findAll(pageable).map(DatosDetalleCurso::new);
    }

}
