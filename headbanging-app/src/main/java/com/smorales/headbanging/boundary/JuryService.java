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
        ScoreMatrix scoreMatrix = participantToVote.getScoreMatrix();
        if (scoreMatrix == null) {
            scoreMatrix = new ScoreMatrix();
            scoreMatrix.setParticipant(participantToVote);
        }

        scoreMatrix = addHandPointsToScoreMatrix(scoreMatrix, handPoints);
        scoreMatrix = addHeadPointsToScoreMatrix(scoreMatrix, headPoints);
        scoreMatrix = calculateTotalAverageScoreMatrix(scoreMatrix);
        scoreMatrix.setTotalScore(scoreMatrix.getTotalScore() + 1);
        participantToVote.setScoreMatrix(scoreMatrix);
        em.persist(participantToVote);
    }

    private ScoreMatrix calculateTotalAverageScoreMatrix(ScoreMatrix matrix) {

        Float totalHeadSum = (float) (matrix.getHead1() + matrix.getHead2() + matrix.getHead3() + matrix.getHead4()
                + matrix.getHead5() + matrix.getHead6() + matrix.getHead7() + matrix.getHead8() + matrix.getHead9() + matrix
                .getHead10());

        Float totalHeadAverage = (float) (totalHeadSum / 10.0);

        Float totalHandSum = (float) (matrix.getHand1() + matrix.getHand2() + matrix.getHand3() + matrix.getHand4()
                + matrix.getHand5() + matrix.getHand6() + matrix.getHand7() + matrix.getHand8() + matrix.getHand9() + matrix
                .getHand10());

        Float totalHandAverage = (float) (totalHandSum / 10.0);
        Float totalAverage = totalHeadAverage + totalHandAverage;
        matrix.setTotalScore(totalAverage);
        return matrix;
    }

    private ScoreMatrix addHeadPointsToScoreMatrix(ScoreMatrix scoreMatrix, Integer points) {
        Integer totalPunctuation;

        switch (points) {
            case 1:
                totalPunctuation = (scoreMatrix.getHead1() + 1);
                scoreMatrix.setHead1(totalPunctuation);
                break;
            case 2:
                totalPunctuation = (scoreMatrix.getHead2() + 1);
                scoreMatrix.setHead2(totalPunctuation);
                break;
            case 3:
                totalPunctuation = (scoreMatrix.getHead3() + 1);
                scoreMatrix.setHead3(totalPunctuation);
                break;
            case 4:
                totalPunctuation = (scoreMatrix.getHead4() + 1);
                scoreMatrix.setHead4(totalPunctuation);
                break;
            case 5:
                totalPunctuation = (scoreMatrix.getHead5() + 1);
                scoreMatrix.setHead5(totalPunctuation);
                break;
            case 6:
                totalPunctuation = (scoreMatrix.getHead6() + 1);
                scoreMatrix.setHead6(totalPunctuation);
                break;
            case 7:
                totalPunctuation = (scoreMatrix.getHead7() + 1);
                scoreMatrix.setHead7(totalPunctuation);
                break;
            case 8:
                totalPunctuation = (scoreMatrix.getHead8() + 1);
                scoreMatrix.setHead8(totalPunctuation);
                break;
            case 9:
                totalPunctuation = (scoreMatrix.getHead9() + 1);
                scoreMatrix.setHead9(totalPunctuation);
                break;
            case 10:
                totalPunctuation = (scoreMatrix.getHead10() + 1);
                scoreMatrix.setHead10(totalPunctuation);
                break;

            default:
                break;
        }
        return scoreMatrix;
    }

    private ScoreMatrix addHandPointsToScoreMatrix(ScoreMatrix scoreMatrix, Integer points) {
        Integer totalPunctuation;

        switch (points) {
            case 1:
                totalPunctuation = (scoreMatrix.getHand1() + 1);
                scoreMatrix.setHand1(totalPunctuation);
                break;
            case 2:
                totalPunctuation = (scoreMatrix.getHand2() + 1);
                scoreMatrix.setHand2(totalPunctuation);
                break;
            case 3:
                totalPunctuation = (scoreMatrix.getHand3() + 1);
                scoreMatrix.setHand3(totalPunctuation);
                break;
            case 4:
                totalPunctuation = (scoreMatrix.getHand4() + 1);
                scoreMatrix.setHand4(totalPunctuation);
                break;
            case 5:
                totalPunctuation = (scoreMatrix.getHand5() + 1);
                scoreMatrix.setHand5(totalPunctuation);
                break;
            case 6:
                totalPunctuation = (scoreMatrix.getHand6() + 1);
                scoreMatrix.setHand6(totalPunctuation);
                break;
            case 7:
                totalPunctuation = (scoreMatrix.getHand7() + 1);
                scoreMatrix.setHand7(totalPunctuation);
                break;
            case 8:
                totalPunctuation = (scoreMatrix.getHand8() + 1);
                scoreMatrix.setHand8(totalPunctuation);
                break;
            case 9:
                totalPunctuation = (scoreMatrix.getHand9() + 1);
                scoreMatrix.setHand9(totalPunctuation);
                break;
            case 10:
                totalPunctuation = (scoreMatrix.getHand10() + 1);
                scoreMatrix.setHand10(totalPunctuation);
                break;

            default:
                break;
        }
        return scoreMatrix;
    }

}
