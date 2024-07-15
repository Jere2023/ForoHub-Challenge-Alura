package com.aluraforohub.DesafioForoHub.DTO.topico;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        Long autorId,
        Long cursoId
) {
}
