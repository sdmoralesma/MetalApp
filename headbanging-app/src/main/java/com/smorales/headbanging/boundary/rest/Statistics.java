package com.smorales.headbanging.boundary.rest;

import com.smorales.headbanging.boundary.AdminDAO;
import com.smorales.headbanging.entity.Participant;

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
    AdminDAO adminDAO;

    @GET
    @Path("/ping")
    public Response getStringTest() {
        return Response.ok("pong").build();
    }

    @GET
    @Path("/ratings/participants")
    public Response getRatingParticipants() {
        return Response.ok(adminDAO.participantList()).build();
    }

    @GET
    @Path("/ratings/songs")
    public Response getRatingSongs() {
        return Response.ok(adminDAO.songList()).build();
    }

    @GET
    @Path("/ratings/participants/{username}")
    public Response getRatingPerParticipant(@PathParam("username") String username) {
        return Response.ok(adminDAO.findParticipantByUsername(username)).build();
    }

}
