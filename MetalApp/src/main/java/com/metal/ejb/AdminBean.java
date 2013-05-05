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
@Named
@Stateless
public class AdminBean {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	@Inject
	private Jury jury;
	@Inject
	private Participant participant;

	private List<Jury> juryList;
	private List<Participant> participantList;

	public AdminBean() {
	}

	@PostConstruct
	public void populateJuryList() {
		this.juryList = this.findAllJuries();
		this.participantList = this.findAllParticipants();
	}

	public void deleteJury(Jury jury) {
		em.remove(em.merge(jury));
	}

	public void deleteParticipant(Participant participant) {
		em.remove(em.merge(participant));
	}

	public List<Jury> findAllJuries() {
		TypedQuery<Jury> query = em.createNamedQuery("Jury.findAll", Jury.class);
		return query.getResultList();
	}

	public List<Participant> findAllParticipants() {
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findAll", Participant.class);
		return query.getResultList();
	}

	public Jury findJuryById(Long id) {
		return em.find(Jury.class, id);
	}

	public Participant findParticipantById(Long id) {
		return em.find(Participant.class, id);
	}

	public Jury getJury() {
		return jury;
	}

	public List<Jury> getJuryList() {
		return juryList;
	}

	public Participant getParticipant() {
		return participant;
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public String registerJury() {
		this.jury.setGroup("jury");
		em.persist(this.jury);
		juryList = this.findAllJuries();
		return "registerJury.xhtml";
	}

	public String registerParticipant() {
		participant.setGroup("participant");
		ScoreMatrix score = new ScoreMatrix();
		score.setUsername(participant.getUsername());
		participant.setScoreMatrix(score);
		em.persist(participant);
		participantList = this.findAllParticipants();
		return "registerParticipant.xhtml";
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}

	public void setJuryList(List<Jury> juryList) {
		this.juryList = juryList;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}

	public Jury updateJury(Jury jury) {
		return em.merge(jury);
	}

	public Participant updateParticipant(Participant participant) {
		return em.merge(participant);
	}

}
