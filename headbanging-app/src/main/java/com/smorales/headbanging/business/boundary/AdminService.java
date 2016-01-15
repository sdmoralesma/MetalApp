package com.smorales.headbanging.business.boundary;

import com.smorales.headbanging.business.entity.Admin;
import com.smorales.headbanging.business.entity.Jury;
import com.smorales.headbanging.business.entity.Participant;

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

    public List<Participant> participantsUsernameLike(String query) {
        return em.createNamedQuery(Participant.findByUsernameLike, Participant.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();
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
        jury.setQualificationsList(null);
        em.persist(jury);
    }

    public void registerParticipant(Participant participant) {
        participant.setGroupName("participant");
        participant.setQualificationsList(null);
        participant.setTotalScore(0.0);
        if (participant.getImageUrl() == null || participant.getImageUrl().equals("")) {
            participant.setImageUrl("default.jpg");
        }
        em.persist(participant);
    }

}
