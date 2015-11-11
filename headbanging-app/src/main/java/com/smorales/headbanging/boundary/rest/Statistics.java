package com.smorales.headbanging.boundary.rest;

import com.smorales.headbanging.boundary.AdminService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/statistics")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class Statistics {

    @Inject
    AdminService adminService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok("pong").build();
    }

    @GET
    @Path("/ratings/participants")
    public Response getRatingParticipants() {
        return Response.ok(adminService.participantList()).build();
    }

    @GET
    @Path("/ratings/participants/{username}")
    public Response getRatingPerParticipant(@PathParam("username") String username) {
        return Response.ok(adminService.findParticipantByUsername(username)).build();
    }

}
