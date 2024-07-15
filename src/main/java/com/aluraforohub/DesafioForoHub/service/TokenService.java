package com.aluraforohub.DesafioForoHub.service;

import com.aluraforohub.DesafioForoHub.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // El secret hay que usar variable de ambiente
            return JWT.create()
                    .withIssuer("ForoHub") // Quien lo emite
                    .withSubject(usuario.getUsername()) // Quien lo recibe
                    .withClaim("id", usuario.getId()) // Esto puede ser una regla de negocio
                    .withExpiresAt(generarExpiracion()) // Esto hace que el Token expire
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    private Instant generarExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubjet(String token) {
        if (token == null) {
            throw new RuntimeException();
        }

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
             verifier = JWT.require(algorithm)
                    .withIssuer("ForoHub")
                    .build()
                     .verify(token);
             verifier.getSubject();


        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
            if (verifier.getSubject() == null) {
                throw new RuntimeException("Sujeto Incorrecto");
            }
        }
        return verifier.getSubject();
    }
}
