package com.engrkirky.app.mapper;

import com.engrkirky.app.dto.LinkDTO;
import com.engrkirky.app.model.Link;

public interface LinkMapper {
    LinkDTO convertToDTO(Link link);
    Link convertToEntity(LinkDTO linkDTO);
}
