package com.aluraforohub.DesafioForoHub.DTO.topico;

public record CrearTopicoDTO(
        String titulo,
        String mensaje,
        String status,
        Long autorId,
        Long cursoId
) {
}
