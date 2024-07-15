package com.keatnis.forohub.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarUsuario(
        @NotBlank
        String nombre,
        @NotBlank(message = "el usuario no debe de estar en blanco")
        String username,
        @NotBlank(message = "el email no debe de estar vacio")
        @Email(message = "verifique el email")
        String email,
        @NotBlank(message = "la contrasena no debe de estar en blanco")
        String password

) {
}
