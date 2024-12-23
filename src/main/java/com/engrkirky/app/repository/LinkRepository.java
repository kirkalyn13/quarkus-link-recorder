package com.engrkirky.app.repository;

import com.engrkirky.app.model.Link;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class LinkRepository {
    private final JPAStreamer jpaStreamer;

    @Inject
    public LinkRepository(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public List<Link> findLinksByStatusCode(short statusCode) {
        return jpaStreamer.stream(Link.class)
                .filter(link -> link.getStatusCode() == statusCode)
                .toList();
    }
}
