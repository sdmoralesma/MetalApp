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

    public void votePerParticipant(Participant participant, Integer handPoints, Integer headPoints) {
        List<Participant> participants = em.createNamedQuery(Participant.FIND_BY_USERNAME, Participant.class)
                .setParameter("username", participant.getUsername())
                .getResultList();

        if (participants.isEmpty()) {
            throw new IllegalArgumentException("participant not found" + participant);
        }

        Participant participantToVote = participants.get(0);
        ScoreMatrix scoreMatrix = participantToVote.getScoreMatrixSet();
        if (scoreMatrix == null) {
            scoreMatrix = new ScoreMatrix();
            scoreMatrix.setParticipantId(participantToVote);
        }

        scoreMatrix = addHandPointsToScoreMatrix(scoreMatrix, handPoints);
        scoreMatrix = addHeadPointsToScoreMatrix(scoreMatrix, headPoints);
        scoreMatrix = calculateTotalAverageScoreMatrix(scoreMatrix);
        scoreMatrix.setTotalScore(scoreMatrix.getTotalScore() + 1);
        participantToVote.setScoreMatrixSet(scoreMatrix);
        em.persist(participantToVote);
    }

    private ScoreMatrix calculateTotalAverageScoreMatrix(ScoreMatrix matrix) {
        double totalHandSum = 0;

        Float totalHandAverage = (float) (totalHandSum / 10.0);
        Float totalHeadAverage = null;
        Float totalAverage = totalHeadAverage + totalHandAverage;
        matrix.setTotalScore(totalAverage);
        return matrix;
    }

    private ScoreMatrix addHeadPointsToScoreMatrix(ScoreMatrix scoreMatrix, Integer points) {
        Integer totalPunctuation;
        return scoreMatrix;
    }

    private ScoreMatrix addHandPointsToScoreMatrix(ScoreMatrix scoreMatrix, Integer points) {
        Integer totalPunctuation;
        return scoreMatrix;
    }

}
