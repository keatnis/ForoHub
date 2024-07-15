package com.keatnis.forohub.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAuthUsuario(
        @NotBlank(message = "ingrese el nombre de usuario")
        String username,
        @NotBlank(message = "ingrese su usuario")
        String password) {
}
