package com.smorales.headbanging.boundary.rest;

import com.smorales.headbanging.boundary.AdminBean;
import com.smorales.headbanging.boundary.JuryBean;
import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.Song;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/statistics")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class Statistics {

    @Inject
    AdminBean adminBean;

    @Inject
    JuryBean juryBean;

    @GET
    @Path("/ping")
    public Response getStringTest() {
        return Response.ok("pong").build();
    }

    @GET
    @Path("/ratings/participants")
    public List<Participant> getRatingParticipants() {
        return adminBean.findAllInstances(Participant.FIND_ALL, Participant.class);
    }

    @GET
    @Path("/ratings/songs")
    public List<Song> getRatingSongs() {
        return juryBean.findAllInstances(Song.FIND_ALL, Song.class);
    }

    @GET
    @Path("/ratings/participants/{idParticipant}")
    public Participant getRatingPerParticipant(@PathParam("idParticipant") Participant participant) {
        return adminBean.findInstanceById(Participant.class, participant.getUsername());
    }

}
