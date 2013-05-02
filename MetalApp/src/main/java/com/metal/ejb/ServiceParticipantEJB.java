package com.metal.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;

/**
 * Permite a un participante ver su propio perfil y modificarlo
 * Based on the article:
 * http://www.andygibson.net/blog/article/comparing-jsf-beans-cdi-beans-and-ejbs/
 */
@Named("participantBean")
@RequestScoped
//@Stateless //Agrega transaccionalidad a las operaciones
public class ServiceParticipantEJB {
	
	@Inject
	private Participant participant;
//	private List<Participant> participantList = new ArrayList<>();

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	/** Default constructor. */
	public ServiceParticipantEJB() {
	}

	// Participant Methods
	public List<Participant> findAllParticipants() {
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findAll", Participant.class);
		return query.getResultList();
	}

	public Participant findParticipantById(Long id) {
		return em.find(Participant.class, id);
	}

	public Participant createParticipant(Participant participant) {
		participant.setGroup("participant");

		ScoreMatrix score = new ScoreMatrix();
		score.setUsername(participant.getUsername());
		// score.setParticipant(participant);
		participant.setScoreMatrix(score);
		em.persist(participant);
		return participant;
	}

	public void deleteParticipant(Participant participant) {
		em.remove(em.merge(participant));
	}

	public Participant updateParticipant(Participant participant) {
		return em.merge(participant);
	}
}
