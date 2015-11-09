package com.smorales.headbanging.boundary.rest;

import com.smorales.headbanging.boundary.AdministratorDAO;
import com.smorales.headbanging.boundary.JuryDAO;
import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.Song;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/statistics")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class Statistics {

    @PersistenceContext
    EntityManager em;

    @Inject
    AdministratorDAO administratorDAO;

    @Inject
    JuryDAO juryDAO;

    @GET
    @Path("/ping")
    public Response getStringTest() {
        return Response.ok("pong").build();
    }

    @GET
    @Path("/ratings/participants")
    public List<Participant> getRatingParticipants() {
        TypedQuery<Participant> typedQuery = em.createNamedQuery(Participant.FIND_ALL, Participant.class);
        return typedQuery.getResultList();
    }

    @GET
    @Path("/ratings/songs")
    public List<Song> getRatingSongs() {
        return juryDAO.findAllInstances(Song.FIND_ALL, Song.class);
    }

    @GET
    @Path("/ratings/participants/{idParticipant}")
    public Participant getRatingPerParticipant(@PathParam("idParticipant") Participant participant) {
        return administratorDAO.findInstanceById(Participant.class, participant.getUsername());
    }

}
