package com.keatnis.forohub.api.infra.errores;

public class ErrorHandlerConsultas extends RuntimeException{
    public ErrorHandlerConsultas(String message) {
        super(message);
    }
}
