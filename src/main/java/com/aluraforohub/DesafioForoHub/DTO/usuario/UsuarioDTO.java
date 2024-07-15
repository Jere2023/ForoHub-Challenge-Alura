package com.aluraforohub.DesafioForoHub.DTO.usuario;

import com.aluraforohub.DesafioForoHub.model.Perfil;

import java.util.List;
import java.util.Set;

public record UsuarioDTO(
        Long id,
        String nombre,
        String correoElectronico,
        String contrasena,
        Set<Perfil> perfiles
) {
}
