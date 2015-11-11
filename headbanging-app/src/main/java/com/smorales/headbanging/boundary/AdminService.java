package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Admin;
import com.smorales.headbanging.entity.Jury;
import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.ScoreMatrix;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdminService {

    @PersistenceContext
    EntityManager em;

    public List<Participant> participantList() {
        return em.createNamedQuery(Participant.FIND_ALL, Participant.class).getResultList();
    }

    public List<Jury> juryList() {
        return em.createNamedQuery(Jury.FIND_ALL, Jury.class).getResultList();
    }

    public List<Admin> adminList() {
        return em.createNamedQuery(Admin.FIND_ALL, Admin.class).getResultList();
    }

    public Participant findParticipantByUsername(Object id) {
        return em.find(Participant.class, id);
    }

    public void registerAdmin(Admin admin) {
        admin.setGroup("admin");
        em.persist(admin);
    }

    public void registerJury(Jury jury) {
        jury.setGroup("jury");
        em.persist(jury);
    }

    public void registerParticipant(Participant participant) {
        participant.setGroup("participant");
        if (participant.getImage_url() == null || participant.getImage_url().equals("")) {
            participant.setImage_url("default.jpg");
        }
        ScoreMatrix score = new ScoreMatrix();
        score.setParticipant(participant);
        participant.setScoreMatrix(score);
        em.persist(participant);
    }

}