package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdminService {

    @PersistenceContext
    EntityManager em;

    public List<Participant> participantList() {
        return em.createNamedQuery(Participant.findAll, Participant.class).getResultList();
    }

    public List<Jury> juryList() {
        return em.createNamedQuery(Jury.findAll, Jury.class).getResultList();
    }

    public List<Admin> adminList() {
        return em.createNamedQuery(Admin.findAll, Admin.class).getResultList();
    }

    public Participant findParticipantByUsername(Object id) {
        return em.find(Participant.class, id);
    }

    public void registerAdmin(Admin admin) {
        admin.setGroupName("admin");
        em.persist(admin);
    }

    public void registerJury(Jury jury) {
        jury.setGroupName("jury");
        jury.setPresentationId(null);
        em.persist(jury);
    }

    public void registerParticipant(Participant participant) {
        participant.setGroupName("participant");
        participant.setPresentation(null);
        participant.setScoreMatrix(null);
        if (participant.getImageUrl() == null || participant.getImageUrl().equals("")) {
            participant.setImageUrl("default.jpg");
        }
        ScoreMatrix score = new ScoreMatrix();
        em.persist(participant);
    }

}
