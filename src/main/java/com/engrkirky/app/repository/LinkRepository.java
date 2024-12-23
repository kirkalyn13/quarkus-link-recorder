package com.engrkirky.app.repository;

import com.engrkirky.app.model.Link;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class LinkRepository {
    private final JPAStreamer jpaStreamer;
    private final EntityManager em;

    @Inject
    public LinkRepository(JPAStreamer jpaStreamer, EntityManager em) {
        this.jpaStreamer = jpaStreamer;
        this.em = em;
    }

    public Optional<Link> findLinkByID(long id) {
        return jpaStreamer.stream(Link.class)
                .filter(link -> link.getId() == id)
                .findFirst();
    }

    public List<Link> findLinksByStatusCode(short statusCode, LocalDateTime start, LocalDateTime end) {
        return jpaStreamer.stream(Link.class)
                .filter(link -> link.getStatusCode() == statusCode
                        && link.getTimestamp().isAfter(start)
                        && link.getTimestamp().isBefore(end))
                .toList();
    }

    public void addLink(Link link) {
        em.persist(link);
    }
}
