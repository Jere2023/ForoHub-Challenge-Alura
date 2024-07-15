package com.aluraforohub.DesafioForoHub.repository;

import com.aluraforohub.DesafioForoHub.model.Curso;
import com.aluraforohub.DesafioForoHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
