package com.engrkirky.app.resource;

import com.engrkirky.app.dto.LinkDTO;
import com.engrkirky.app.service.LinkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/links")
public class LinkResource {
    private final LinkService linkService;
    private final ObjectMapper objectMapper;

    @Inject
    public LinkResource(LinkService linkService, ObjectMapper objectMapper) {
        this.linkService = linkService;
        this.objectMapper = objectMapper;
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLinkByID(long id) {
        LinkDTO result = linkService.getLinkByID(id);
        return Response.ok(objectMapper.valueToTree(result)).build();
    }

    @GET
    @Path(("/status/{statusCode}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLinksByStatusCode(short statusCode) {
        List<LinkDTO> results = linkService.getLinksByStatusCode(statusCode);
        return Response.ok(objectMapper.valueToTree(results)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLink(LinkDTO linkDTO) {
        boolean result = linkService.addLink(linkDTO);
        return result
                ? Response.status(Response.Status.CREATED).build()
                : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
