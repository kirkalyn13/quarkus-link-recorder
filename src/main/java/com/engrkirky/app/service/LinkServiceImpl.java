package com.engrkirky.app.service;

import com.engrkirky.app.dto.LinkDTO;
import com.engrkirky.app.mapper.LinkMapper;
import com.engrkirky.app.model.Link;
import com.engrkirky.app.repository.LinkRepository;
import com.engrkirky.app.util.LinkUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;
    private final LinkMapper linkMapper;

    @Inject
    public LinkServiceImpl(LinkRepository linkRepository, LinkMapper linkMapper) {
        this.linkRepository = linkRepository;
        this.linkMapper = linkMapper;
    }

    @Override
    public LinkDTO getLinkByID(long id) {
        Link link = linkRepository.findLinkByID(id).orElseThrow();
        return linkMapper.convertToDTO(link);
    }

    @Override
    public List<LinkDTO> getLinksByStatusCode(short statusCode, LocalDateTime start, LocalDateTime end) {
        return linkRepository.findLinksByStatusCode(statusCode, start, end).stream()
                .map(linkMapper::convertToDTO)
                .toList();
    }

    @Override
    @Transactional
    public boolean addLink(LinkDTO linkDTO) {
        if (!LinkUtil.isValidHttpStatusCode(linkDTO.statusCode())) return false;
        linkRepository.addLink(linkMapper.convertToEntity(linkDTO));

        return true;
    }
}
