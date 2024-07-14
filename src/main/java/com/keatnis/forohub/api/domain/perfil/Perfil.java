package com.keatnis.forohub.api.domain.perfil;

import com.keatnis.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "perfil")
@Entity(name = "Perfil")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
//    private List<Usuario> usuario;

    public Perfil(String nombre) {
        this.nombre = nombre;
    }
}
