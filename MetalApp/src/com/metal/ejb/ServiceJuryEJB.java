package com.metal.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.metal.model.Participant;
import com.metal.model.Song;

/**
 * Vota por Concursante y Vota por Cancion
 */
@Stateless
@LocalBean
public class ServiceJuryEJB {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	/** Default constructor. */
	public ServiceJuryEJB() {
		super();
	}

	public Participant findParticipant(Long id) {
		return em.find(Participant.class, id);
	}

	public Song findSong(Long id) {
		return em.find(Song.class, id);
	}

	public void addVotePerParticipant(Participant participant) {
		Query query = em.createNamedQuery("Participant.findByUsername").setParameter("username",
				participant.getUsername());
		List<Participant> participants = query.getResultList();
		System.out.println(participants.get(0));
	}

	public void addVotePerSong(Song song) {
		Query query = em.createNamedQuery("Song.findByTitle", Song.class).setParameter("title", song.getTitle());
		List<Song> songs = query.getResultList();
		System.out.println(songs.get(0));
	}
}
