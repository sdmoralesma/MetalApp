package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.ScoreMatrix;

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

        ScoreMatrix scoreMatrix = participant.getScoreMatrix();
        if (scoreMatrix == null) {
            scoreMatrix = new ScoreMatrix();
            scoreMatrix.setTotalScore((float) points);
            scoreMatrix.setParticipant(participant);
            participant.setScoreMatrix(scoreMatrix);
        }

        em.persist(participant);
    }

}
