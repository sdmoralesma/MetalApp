package com.metal.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;
import com.metal.model.Song;

/**
 * Vota por Concursante y Vota por Cancion
 */
@Named
@Stateless
public class JuryBean {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	@Inject
	private Participant participant;
	@Inject
	private Song song;

	private List<Participant> participantList;
	private List<Song> songList;

	public JuryBean() {
	}

	@PostConstruct
	public void populateLists() {
		this.songList = this.findAllInstances("Song.findAll", Song.class);
		this.participantList = this.findAllInstances("Participant.findAll", Participant.class);
	}

	public <T> List<T> findAllInstances(String query, Class<T> clazz) {
		TypedQuery<T> typedQuery = em.createNamedQuery(query, clazz);
		return typedQuery.getResultList();
	}

	public <T> T findInstanceById(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}

	public <T> T updateInstance(T instance) {
		return em.merge(instance);
	}

	public <T> void deleteInstance(T instance) {
		em.remove(em.merge(instance));
	}

	public void addVotePerParticipant(Participant participant) {
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findByUsername", Participant.class)
				.setParameter("username", participant.getUsername());
		participant = query.getResultList().get(0);
		if (participant != null) {

			System.out.println("PARTICIPANT" + participant);//

			TypedQuery<ScoreMatrix> scoreQuery = em.createNamedQuery("ScoreMatrix.findByUsername", ScoreMatrix.class)
					.setParameter("username", participant.getUsername());

			if (scoreQuery.getFirstResult() != 0) {
				ScoreMatrix score = scoreQuery.getResultList().get(0);
				System.out.println("SCORE" + score);

				score.setTotalScore(score.getTotalScore() + 1);
				participant.setScoreMatrix(score);
				em.persist(participant);

			} else {
				System.out.println("NO EXISTE SCORE PARA EL PARTICIPANTE");
			}

		} else {
			System.out.println("NO EXISTE EL PARTICIPANTE");
		}
	}

	public void addVotePerSong(Song song) {
		TypedQuery<Song> query = em.createNamedQuery("Song.findByTitle", Song.class).setParameter("title",
				song.getTitle());
		List<Song> songs = query.getResultList();
		if (songs.isEmpty()) {
			System.out.println("No songs");
		} else {
			System.out.println(songs.get(0));
		}
	}
	
	// Getters & Setters
	// --------------------------------------------------------------

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

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
}
