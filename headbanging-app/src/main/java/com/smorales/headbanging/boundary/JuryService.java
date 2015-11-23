package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JuryService {

    @PersistenceContext
    EntityManager em;

    public void votePerParticipant(Participant p, Integer points) {
        Participant participant = em.createNamedQuery(Participant.findByUsername, Participant.class)
                .setParameter("username", p.getUsername())
                .getSingleResult();

        participant.setTotalScore((double) points);

        em.persist(participant);
    }

}
