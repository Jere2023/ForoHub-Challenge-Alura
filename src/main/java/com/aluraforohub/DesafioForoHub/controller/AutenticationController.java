package com.aluraforohub.DesafioForoHub.controller;

import com.aluraforohub.DesafioForoHub.DTO.usuario.AutenticacionUsuario;
import com.aluraforohub.DesafioForoHub.DTO.usuario.DatosJWToken;
import com.aluraforohub.DesafioForoHub.model.Usuario;
import com.aluraforohub.DesafioForoHub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid AutenticacionUsuario autenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticacionUsuario.nombre(),
                autenticacionUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWToken(JWToken));
    }
}
