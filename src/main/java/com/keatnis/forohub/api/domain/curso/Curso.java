package com.keatnis.forohub.api.domain.curso;

import com.keatnis.forohub.api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<Topico> topicos;

    public Curso(DatosRegistroCurso datos) {
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
    }
}
