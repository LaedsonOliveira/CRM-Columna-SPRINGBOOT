package com.dev.laedson.crmColumna.dto;

import java.util.UUID;

public record CreateEnterpriseDto(String name, String CNPJ, String category, UUID owner) {
}
