package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ParticipantService {

    @PersistenceContext
    EntityManager em;

    public Participant findParticipantByUsername(String username) {
        List<Participant> participants = em.createNamedQuery(User.findByParticipantByUsername, Participant.class)
                .setParameter("username", username)
                .getResultList();

        return (Participant) participants.get(0);
    }

    public void updateParticipant(Participant participant) {
        em.merge(participant);
    }

    public void deleteParticipant(Participant participant) {
        em.remove(em.merge(participant));
    }

}
