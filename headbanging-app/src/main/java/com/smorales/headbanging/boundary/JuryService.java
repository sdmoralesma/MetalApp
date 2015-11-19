package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.ScoreMatrix;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class JuryService {

    @PersistenceContext
    EntityManager em;

    public void votePerParticipant(Participant participant, Integer points) {
        List<Participant> participants = em.createNamedQuery(Participant.findByUsername, Participant.class)
                .setParameter("username", participant.getUsername())
                .getResultList();

        if (participants.isEmpty()) {
            throw new IllegalArgumentException("participant not found: " + participant.getUsername());
        }

        Participant participantToVote = participants.get(0);
        ScoreMatrix scoreMatrix = participantToVote.getScoreMatrix();
        if (scoreMatrix == null) {

        }

        em.persist(participantToVote);
    }


}
