package com.keatnis.forohub.api.errores;

public class ErrorHandlerConsultas extends RuntimeException{
    public ErrorHandlerConsultas(String message) {
        super(message);
    }
}
