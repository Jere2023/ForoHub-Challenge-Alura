package com.aluraforohub.DesafioForoHub.repository;

import com.aluraforohub.DesafioForoHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
