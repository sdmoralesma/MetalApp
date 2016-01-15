package com.smorales.headbanging.business.boundary;

import com.smorales.headbanging.business.entity.Jury;
import com.smorales.headbanging.business.entity.Participant;
import com.smorales.headbanging.business.entity.Qualifications;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.OptionalDouble;

@Stateless
public class JuryService {

    @PersistenceContext
    EntityManager em;

    public void votePerParticipant(String currentJury, Participant p, Integer points) {
        Participant participant = em.createNamedQuery(Participant.findByUsername, Participant.class)
                .setParameter("username", p.getUsername())
                .getSingleResult();

        Jury jury = em.createNamedQuery(Jury.findByUsername, Jury.class)
                .setParameter("username", currentJury)
                .getSingleResult();

        if (alreadyVoted(jury, participant)) {
            return;
        }

        Qualifications newQualification = new Qualifications();
        newQualification.setJuryId(jury);
        newQualification.setParticipantId(participant);
        newQualification.setScore(points);

        participant.getQualificationsList().add(newQualification);
        participant.setTotalScore(calculateAverage(participant.getQualificationsList()));
        em.persist(participant);
    }

    private boolean alreadyVoted(Jury jury, Participant participant) {
        return participant.getQualificationsList().stream()
                .anyMatch(q -> q.getJuryId().getUserId().equals(jury.getUserId()));
    }

    private Double calculateAverage(List<Qualifications> qualifications) {
        OptionalDouble average = qualifications.stream()
                .mapToDouble(Qualifications::getScore)
                .average();
        return average.getAsDouble();
    }

}
