package com.keatnis.forohub.api.domain.usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String username,
        String email
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(),usuario.getUsername(),usuario.getEmail());
    }
}
