package com.engrkirky.app.mapper;

import com.engrkirky.app.dto.LinkDTO;
import com.engrkirky.app.model.Link;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkMapperImplTest {
    private LinkMapperImpl underTest;
    private static final LocalDateTime now = LocalDateTime.now();
    private static final LinkDTO dto = new LinkDTO(1L, now, "google.com", (short) 200);
    private static final Link entity = Link.builder()
            .id(1L)
            .timestamp(now)
            .url("google.com")
            .statusCode((short) 200)
            .build();

    @BeforeEach
    void setUp() {
        underTest = new LinkMapperImpl();
    }

    @Test
    void shouldConvertToDTO() {
        LinkDTO result = underTest.convertToDTO(entity);
        assertEquals(result, dto);
    }

    @Test
    void shouldConvertToEntity() {
        Link result = underTest.convertToEntity(dto);
        result.setId(1L); // mock auto generate ID
        assertEquals(result, entity);
    }
}
