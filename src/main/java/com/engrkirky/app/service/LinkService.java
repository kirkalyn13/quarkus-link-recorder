package com.engrkirky.app.service;

import com.engrkirky.app.dto.LinkDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface LinkService {
    LinkDTO getLinkByID(long id);
    List<LinkDTO> getLinksByStatusCode(short statusCode, LocalDateTime start, LocalDateTime end);
    boolean addLink(LinkDTO linkDTO);
}
