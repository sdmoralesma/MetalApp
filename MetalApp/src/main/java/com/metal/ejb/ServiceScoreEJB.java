package com.metal.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Artist;
import com.metal.model.Gender;
import com.metal.model.Song;

/**
 * Consolidar Puntaje, Registrar Cancion, Registrar Genero
 */
@Named("scoreBean")
@Stateless
public class ServiceScoreEJB {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	@Inject
	private Gender gender;
	@Inject
	private List<Gender> genderList;
	@Inject
	private Song song;
	@Inject
	private Artist artist;
	@Inject
	private List<Song> songList;

	public ServiceScoreEJB() {
	}

	@PostConstruct
	public void populateGenderList() {
		this.genderList = this.findAllGenders();
		this.songList = this.findAllSongs();
	}

	public String createSong() {
		song.setArtist(artist);
		song.setGender(gender);
		Artist artist = new Artist();
		artist.setIdArtist(song.getArtist().getIdArtist());

		Gender gender = new Gender();
		gender.setIdGender(song.getGender().getIdGender());

		song.setArtist(artist);
		song.setGender(gender);
		em.persist(song);
		songList = this.findAllSongs();
		return "registerSong.xhtml";
	}

	public String createGender() {
		em.persist(this.gender);
		this.populateGenderList();
		return "registerGender.xhtml";
	}

	public List<Song> findAllSongs() {
		TypedQuery<Song> query = em.createNamedQuery("Song.findAll", Song.class);
		return query.getResultList();
	}

	public List<Gender> findAllGenders() {
		TypedQuery<Gender> query = em.createNamedQuery("Gender.findAll", Gender.class);
		return query.getResultList();
	}

	public String doVotePerSong() {
		songList = this.findAllSongs();
		return "votePerSong.xhtml";
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Gender> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Gender> genderList) {
		this.genderList = genderList;
	}
}
