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
        return em.createNamedQuery(Participant.FIND_ALL, Participant.class).getResultList();
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
        jury.setGroupName("jury");//TODO: remove hardcoded data
        jury.setDescription("a description");
        jury.setName("a name");
        jury.setPassword("password");
        jury.setUsername("username");
        jury.setJuryInfo("info");
        jury.setPresentationId(null);
        em.persist(jury);

    }

    public void registerParticipant(Participant participant) {
        participant.setGroupName("participant");
        if (participant.getImageUrl() == null || participant.getImageUrl().equals("")) {
            participant.setImageUrl("default.jpg");
        }
        ScoreMatrix score = new ScoreMatrix();
        em.persist(participant);
    }

}
