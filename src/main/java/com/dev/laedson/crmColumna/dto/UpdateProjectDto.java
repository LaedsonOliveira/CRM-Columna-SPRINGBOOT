package com.dev.laedson.crmColumna.dto;

import java.util.UUID;

public record UpdateProjectDto(UUID projectId, String nome, String descricao) {
}
