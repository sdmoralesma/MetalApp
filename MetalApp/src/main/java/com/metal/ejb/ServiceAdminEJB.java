package com.metal.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Jury;
import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;

/**
 * Registra Usuarios y Administradores en el sistema
 */
@Named("adminBean")
@Stateless
public class ServiceAdminEJB {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	@Inject
	private Jury jury;
	@Inject
	private List<Jury> juryList;
	@Inject
	private Participant participant;
	@Inject
	private List<Participant> participantList;

	public ServiceAdminEJB() {
	}

	@PostConstruct
	public void populateJuryList() {
		this.juryList = this.findAllJuries();
		this.participantList = this.findAllParticipants();
	}

	// Participant Methods
	public List<Participant> findAllParticipants() {
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findAll", Participant.class);
		return query.getResultList();
	}

	public Participant findParticipantById(Long id) {
		return em.find(Participant.class, id);
	}

	public String createParticipant() {
		participant.setGroup("participant");

		ScoreMatrix score = new ScoreMatrix();
		score.setUsername(participant.getUsername());
		// score.setParticipant(participant);
		participant.setScoreMatrix(score);
		em.persist(participant);
		return "registerParticipant.xhtml";
	}

	public void deleteParticipant(Participant participant) {
		em.remove(em.merge(participant));
	}

	public Participant updateParticipant(Participant participant) {
		return em.merge(participant);
	}

	// Jury Methods
	public List<Jury> findAllJuries() {
		TypedQuery<Jury> query = em.createNamedQuery("Jury.findAll", Jury.class);
		return query.getResultList();
	}

	public Jury findJuryById(Long id) {
		return em.find(Jury.class, id);
	}

	public String registerJury() {
		this.jury.setGroup("jury");
		em.persist(this.jury);
		return "registerJury.xhtml";
	}

	public void deleteJury(Jury jury) {
		em.remove(em.merge(jury));
	}

	public Jury updateJury(Jury jury) {
		return em.merge(jury);
	}

	public Jury getJury() {
		return jury;
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}

	public List<Jury> getJuryList() {
		return juryList;
	}

	public void setJuryList(List<Jury> juryList) {
		this.juryList = juryList;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}

}
