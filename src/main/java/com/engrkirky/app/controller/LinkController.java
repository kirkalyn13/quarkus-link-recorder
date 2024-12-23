package com.engrkirky.app.controller;

import com.engrkirky.app.model.Link;
import com.engrkirky.app.repository.LinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/link")
public class LinkController {
    private final LinkRepository linkRepository;
    private final ObjectMapper objectMapper;

    @Inject
    public LinkController(LinkRepository linkRepository, ObjectMapper objectMapper) {
        this.linkRepository = linkRepository;
        this.objectMapper = objectMapper;
    }

    @GET
    @Path(("/status/{statusCode}"))
    @Produces(MediaType.TEXT_PLAIN)
    public Response getLinksByStatusCode(short statusCode) {
        List<Link> results = linkRepository.findLinksByStatusCode(statusCode);
        return Response.ok(objectMapper.valueToTree(results)).build();
    }
}
