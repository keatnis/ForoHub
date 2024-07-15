package com.keatnis.forohub.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.keatnis.forohub.api.domain.usuario.Usuario;
import com.keatnis.forohub.api.infra.errores.ErrorHandlerConsultas;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.jwt.secret}")
    private String apiSecret;
    @Value("${api.security.jwt.expiration}")
    private Integer expiration;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            System.out.println(apiSecret);
            return JWT.create()
                    .withIssuer("Foro Hub API")
                    .withSubject(usuario.getUsername())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new ErrorHandlerConsultas("Token no ingresado en el encabezado (Auth)");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma guardada en el archivo application.yml
            return  JWT.require(algorithm)
                    .withIssuer("Foro Hub API")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new ErrorHandlerConsultas("Token JWT inválido o expirado!");
        }

    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(expiration).toInstant(ZoneOffset.of("-05:00"));
    }

}

