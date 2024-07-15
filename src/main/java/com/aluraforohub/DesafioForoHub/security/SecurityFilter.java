package com.aluraforohub.DesafioForoHub.security;

import com.aluraforohub.DesafioForoHub.repository.UsuarioRepository;
import com.aluraforohub.DesafioForoHub.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //System.out.println("Filtro Llamado");
        //Obtener el token del header
        var autHeader = request.getHeader("Authorization");
        if (autHeader != null) {
             var token = autHeader.replace("Bearer ", "");
             var subject = tokenService.getSubjet(token);
             if (subject != null) {
                 var usuario = usuarioRepository.findByNombre(subject);
                 var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                         usuario.getAuthorities());
                 SecurityContextHolder.getContext().setAuthentication(authentication);
             }
     }
        filterChain.doFilter(request, response); // esto hace que llame al siguiente filtro
    }
}
