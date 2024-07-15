package com.aluraforohub.DesafioForoHub.service;

import com.aluraforohub.DesafioForoHub.DTO.topico.ActualizarTopicoDTO;
import com.aluraforohub.DesafioForoHub.DTO.topico.CrearTopicoDTO;
import com.aluraforohub.DesafioForoHub.DTO.topico.TopicoDTO;
import com.aluraforohub.DesafioForoHub.model.Curso;
import com.aluraforohub.DesafioForoHub.model.Topico;
import com.aluraforohub.DesafioForoHub.model.Usuario;
import com.aluraforohub.DesafioForoHub.repository.CursoRepository;
import com.aluraforohub.DesafioForoHub.repository.TopicoRepository;
import com.aluraforohub.DesafioForoHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<TopicoDTO> obtenerTodos() {
        return topicoRepository.findAll().stream()
                .map(topico -> new TopicoDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion(),
                        topico.getStatus(),
                        topico.getAutor().getId(),
                        topico.getCurso().getId()
                ))
                .collect(Collectors.toList());
    }

    public Optional<TopicoDTO> obtenerPorId(Long id) {
        return topicoRepository.findById(id)
                .map(topico -> new TopicoDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion(),
                        topico.getStatus(),
                        topico.getAutor().getId(),
                        topico.getCurso().getId()
                ));
    }

    public TopicoDTO crear(CrearTopicoDTO crearTopicoDTO) {
        Topico topico = new Topico();
        topico.setTitulo(crearTopicoDTO.titulo());
        topico.setMensaje(crearTopicoDTO.mensaje());
        topico.setStatus(crearTopicoDTO.status());
        topico.setAutor(obtenerAutorPorId(crearTopicoDTO.autorId()));
        topico.setCurso(obtenerCursoPorId(crearTopicoDTO.cursoId()));
        topico.setFechaCreacion(LocalDateTime.now());

        Topico topicoGuardado = topicoRepository.save(topico);

        return new TopicoDTO(
                topicoGuardado.getId(),
                topicoGuardado.getTitulo(),
                topicoGuardado.getMensaje(),
                topicoGuardado.getFechaCreacion(),
                topicoGuardado.getStatus(),
                topicoGuardado.getAutor().getId(),
                topicoGuardado.getCurso().getId()
        );
    }

    public Optional<TopicoDTO> actualizar(Long id, ActualizarTopicoDTO actualizarTopicoDTO) {
        return topicoRepository.findById(id)
                .map(topico -> {
                    topico.setTitulo(actualizarTopicoDTO.titulo());
                    topico.setMensaje(actualizarTopicoDTO.mensaje());
                    topico.setStatus(actualizarTopicoDTO.status());
                    Topico topicoActualizado = topicoRepository.save(topico);

                    return new TopicoDTO(
                            topicoActualizado.getId(),
                            topicoActualizado.getTitulo(),
                            topicoActualizado.getMensaje(),
                            topicoActualizado.getFechaCreacion(),
                            topicoActualizado.getStatus(),
                            topicoActualizado.getAutor().getId(),
                            topicoActualizado.getCurso().getId()
                    );
                });
    }

    public void eliminar(Long id) {
        topicoRepository.deleteById(id);
    }

    // Métodos auxiliares para obtener autor y curso

    private Usuario obtenerAutorPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    private Curso obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}

