package com.metal.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.event.FileUploadEvent;

import com.metal.model.Participant;

/**
 * Permite a un participante ver su propio perfil y modificarlo
 */
@Named("participantBean")
@Stateless
public class ServiceParticipantEJB {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	private Participant participant;

	public ServiceParticipantEJB() {
	}

	@PostConstruct
	public void populateParticipant() {
		this.participant = this.findParticipantByPK();
	}

	public Participant findParticipantByPK() {
		String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findByUsername", Participant.class);
		query.setParameter("username", nameLoggedUser);
		return query.getSingleResult();
	}

	public void deleteParticipant() {
		em.remove(em.merge(this.participant));
	}

	public Participant updateParticipant() {
		Participant participant = em.merge(this.participant); 
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Updated Correctly"));
		return participant;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        
    }  
}
