package com.keatnis.forohub.api.domain.usuario;

import com.keatnis.forohub.api.domain.perfil.Perfil;
import com.keatnis.forohub.api.domain.respuesta.Respuesta;
import com.keatnis.forohub.api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Table(name = "usuario")
@Entity(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String password;


    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Topico> topicos;
    //
//    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
//    private List<Perfil> perfil;
//
    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    public Usuario(DatosRegistrarUsuario datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.password = datos.password();
        this.username = datos.username();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        //   return UserDetails.super.isAccountNonExpired();
        return true;

    }

    @Override
    public boolean isAccountNonLocked() {
        // return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        // return UserDetails.super.isEnabled();
        return true;
    }
}