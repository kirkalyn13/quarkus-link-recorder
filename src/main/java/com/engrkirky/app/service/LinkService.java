package com.engrkirky.app.service;

import com.engrkirky.app.dto.LinkDTO;

import java.util.List;

public interface LinkService {
    LinkDTO getLinkByID(long id);
    List<LinkDTO> getLinksByStatusCode(short statusCode);
    void addLink(LinkDTO linkDTO);
}
