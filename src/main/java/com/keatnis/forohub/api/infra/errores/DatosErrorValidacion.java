package com.keatnis.forohub.api.infra.errores;

import org.springframework.validation.FieldError;
// se valida cada campo del dto y en caso de haber un error se muertra al cliente el mensaje y el campo
public record DatosErrorValidacion(String campo, String mensaje) {
    public DatosErrorValidacion (FieldError error){
        this(error.getField(),error.getDefaultMessage());
    }
}
