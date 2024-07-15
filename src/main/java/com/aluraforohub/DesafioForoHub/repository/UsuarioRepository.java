package com.aluraforohub.DesafioForoHub.repository;

import com.aluraforohub.DesafioForoHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByNombre(String nombre);
}
