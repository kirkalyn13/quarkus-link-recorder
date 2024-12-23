package com.engrkirky.app.dto;

import java.time.LocalDateTime;

public record LinkDTO(
    Long id,
    LocalDateTime timestamp,
    String url,
    short statusCode
) {}
