package com.metal.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.resource.NotSupportedException;

import com.metal.model.Gender;
import com.metal.model.Jury;
import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;
import com.metal.model.Song;

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
	@Inject
	private Song song;
	@Inject
	private Gender gender;

	@Named
	private List<Jury> juryList;
	@Named
	private List<Participant> participantList;
	@Named
	private List<Song> songList;
	@Named
	private List<Gender> genderList;

	public AdminBean() {
	}

	@PostConstruct
	public void populateJuryList() {
		this.juryList = this.findAllInstances("Jury.findAll", Jury.class);
		this.participantList = this.findAllInstances("Participant.findAll", Participant.class);
		this.songList = this.findAllInstances("Song.findAll", Song.class);
		this.genderList = this.findAllInstances("Gender.findAll", Gender.class);
	}

	public <T> void deleteInstance(T instance) {
		em.remove(em.merge(instance));
	}

	// public void deleteJury(Jury j) {
	// em.remove(em.merge(j));
	// }
	//
	// public void deleteParticipant(Participant p) {
	// em.remove(em.merge(p));
	// }
	//
	// public void deleteSong(Song s) {
	// em.remove(em.merge(s));
	// }
	//
	// public void deleteGender(Gender g) {
	// em.remove(em.merge(g));
	// }

	public <T> List<T> findAllInstances(String query, Class<T> clazz) {
		TypedQuery<T> typedQuery = em.createNamedQuery(query, clazz);
		return typedQuery.getResultList();
	}

	// public List<Jury> findAllJuries() {
	// TypedQuery<Jury> query = em.createNamedQuery("Jury.findAll", Jury.class);
	// return query.getResultList();
	// }
	//
	// public List<Participant> findAllParticipants() {
	// TypedQuery<Participant> query =
	// em.createNamedQuery("Participant.findAll", Participant.class);
	// return query.getResultList();
	// }
	//
	// public List<Song> findAllSongs() {
	// TypedQuery<Song> query = em.createNamedQuery("Song.findAll", Song.class);
	// return query.getResultList();
	// }
	//
	// public List<Gender> findAllGenders() {
	// TypedQuery<Gender> query = em.createNamedQuery("Gender.findAll",
	// Gender.class);
	// return query.getResultList();
	// }

	public <T> T findInstanceById(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}

	// public Jury findJuryById(String id) {
	// return em.find(Jury.class, id);
	// }
	//
	// public Participant findParticipantById(String id) {
	// return em.find(Participant.class, id);
	// }
	//
	// public Song findSongById(String id) {
	// return em.find(Song.class, id);
	// }
	//
	// public Gender findGenderById(String id) {
	// return em.find(Gender.class, id);
	// }

	public String registerJury() {
		this.jury.setGroup("jury");
		em.persist(this.jury);
		juryList = this.findAllInstances("Jury.findAll", Jury.class);
		return "registerJury.xhtml";
	}

	public String registerParticipant() {
		participant.setGroup("participant");
		ScoreMatrix score = new ScoreMatrix();
		score.setUsername(participant.getUsername());
		participant.setScoreMatrix(score);
		em.persist(participant);
		participantList = this.findAllInstances("Participant.findAll", Participant.class);
		return "registerParticipant.xhtml";
	}

	public String registerSong() throws NotSupportedException {
		throw new NotSupportedException("Método no implementado");
	}

	public String registerGender() throws NotSupportedException {
		throw new NotSupportedException("Método no implementado");
	}

	public <T> T updateInstance(T instance) {
		return em.merge(instance);
	}

	// public Jury updateJury(Jury j) {
	// return em.merge(j);
	// }
	//
	// public Participant updateParticipant(Participant p) {
	// return em.merge(p);
	// }
	//
	// public Song updateParticipant(Song s) {
	// return em.merge(s);
	// }
	//
	// public Gender updateGender(Gender g) {
	// return em.merge(g);
	// }
}
