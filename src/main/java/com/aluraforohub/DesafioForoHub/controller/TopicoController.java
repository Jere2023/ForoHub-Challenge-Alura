package com.aluraforohub.DesafioForoHub.controller;

import com.aluraforohub.DesafioForoHub.DTO.topico.ActualizarTopicoDTO;
import com.aluraforohub.DesafioForoHub.DTO.topico.CrearTopicoDTO;
import com.aluraforohub.DesafioForoHub.DTO.topico.TopicoDTO;
import com.aluraforohub.DesafioForoHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;


    @GetMapping
    public ResponseEntity<List<TopicoDTO>> obtenerTodos() {
        return ResponseEntity.ok(topicoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> obtenerPorId(@PathVariable @Valid Long id) {
        Optional<TopicoDTO> topico = topicoService.obtenerPorId(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> crear(@RequestBody @Valid CrearTopicoDTO crearTopicoDTO) {
        TopicoDTO topicoCreado = topicoService.crear(crearTopicoDTO);
        return ResponseEntity.ok(topicoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> actualizar(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO actualizarTopicoDTO) {
        Optional<TopicoDTO> topicoActualizado = topicoService.actualizar(id, actualizarTopicoDTO);
        return topicoActualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
