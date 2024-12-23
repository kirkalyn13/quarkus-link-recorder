package com.engrkirky.app.mapper;

import com.engrkirky.app.dto.LinkDTO;
import com.engrkirky.app.model.Link;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LinkMapperImpl implements LinkMapper {
    public LinkDTO convertToDTO(Link link) {
        return new LinkDTO(link.getId(), link.getTimestamp(), link.getUrl(), link.getStatusCode());
    }

    public Link convertToEntity(LinkDTO linkDTO) {
        return Link.builder()
                .id(linkDTO.id())
                .timestamp(linkDTO.timestamp())
                .url(linkDTO.url())
                .statusCode(linkDTO.statusCode())
                .build();
    }
}
