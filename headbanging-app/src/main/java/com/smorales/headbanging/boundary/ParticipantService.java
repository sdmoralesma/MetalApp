package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipantService {

    @PersistenceContext
    EntityManager em;

    public Participant findParticipantByUsername(String username) {
        return em.createNamedQuery(Participant.findByUsername, Participant.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public void updateParticipant(Participant participant) {
        em.merge(participant);
    }

    public void deleteParticipant(Participant participant) {
        em.remove(em.merge(participant));
    }

}
