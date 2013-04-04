package com.metal.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Artist;
import com.metal.model.Gender;
import com.metal.model.Song;

/**
 * Consolidar Puntaje, Registrar Canción, Registrar Género
 */
@Stateless
@LocalBean
public class ServiceScoreEJB {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ServiceScoreEJB() {
	}

	public Song createSong(Song song) {
		Artist artist = new Artist();
		artist.setIdArtist(song.getArtist().getIdArtist());

		Gender gender = new Gender();
		gender.setIdGender(song.getGender().getIdGender());

		song.setArtist(artist);
		song.setGender(gender);
		em.persist(song);
		return song;
	}

	public Gender createGender(Gender gender) {
		em.persist(gender);
		return gender;
	}

	public List<Song> findAllSongs() {
		TypedQuery<Song> query = em.createNamedQuery("Song.findAll", Song.class);
		return query.getResultList();
	}

	public List<Gender> findAllGenders() {
		TypedQuery<Gender> query = em.createNamedQuery("Gender.findAll", Gender.class);
		return query.getResultList();
	}

}
