package com.dev.laedson.crmColumna.dto;

import java.util.Date;

public record CreateProjectDto(String name, String description, Date startDate, Date endDate) {
}
