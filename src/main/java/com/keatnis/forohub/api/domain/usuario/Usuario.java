package com.keatnis.forohub.api.domain.usuario;

import com.keatnis.forohub.api.domain.perfil.Perfil;
import com.keatnis.forohub.api.domain.respuesta.Respuesta;
import com.keatnis.forohub.api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Perfil> perfiles;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Topico> topicos;

    @OneToMany(mappedBy = "usuario" )
    private List<Respuesta> respuestas;
}
