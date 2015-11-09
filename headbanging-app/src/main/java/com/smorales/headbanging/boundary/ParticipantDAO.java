package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipantDAO {

    @PersistenceContext
    EntityManager em;

    public Participant findParticipantByPK() {
        String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return em.createNamedQuery(Participant.FIND_BY_USERNAME, Participant.class)
                .setParameter("username", nameLoggedUser)
                .getSingleResult();
    }

    public void updateParticipant(Participant participant) {
        em.merge(participant);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Updated Participant");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public void deleteParticipant(Participant participant) {
        em.remove(em.merge(participant));
    }

}
