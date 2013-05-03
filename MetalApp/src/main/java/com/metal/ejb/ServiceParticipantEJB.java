package com.metal.ejb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.metal.model.Participant;

/**
 * Permite a un participante ver su propio perfil y modificarlo
 * 
 * Based on the article:
 * http://www.andygibson.net/blog/article/comparing-jsf-beans-cdi-beans-and-ejbs/
 */
@Named("participantBean")
@RequestScoped
public class ServiceParticipantEJB {
	
	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;
	
	private Participant participant;
	private String message = "The message";
	/** Default constructor. */
	public ServiceParticipantEJB() {
	}
	
//	@PostConstruct
//	public void populateParticipantList() {
//		this.participant = this.findParticipantById((long) 0);
//
//	}

	public Participant findParticipantById(Long id) {
		return em.find(Participant.class, id);
	}

	public void deleteParticipant(Participant participant) {
		em.remove(em.merge(participant));
	}

	public Participant updateParticipant(Participant participant) {
		return em.merge(participant);
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public String getSomeText() {
		return "Some Text that must be shown";
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	
}
