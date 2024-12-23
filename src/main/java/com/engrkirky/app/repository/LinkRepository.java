package com.engrkirky.app.repository;

import com.engrkirky.app.model.Link;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

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

    public List<Link> findLinksByStatusCode(short statusCode) {
        return jpaStreamer.stream(Link.class)
                .filter(link -> link.getStatusCode() == statusCode)
                .toList();
    }

    public void addLink(Link link) {
        em.persist(link);
    }
}
