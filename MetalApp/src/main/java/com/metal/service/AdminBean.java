package com.metal.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Artist;
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
	@Inject
	private Artist artist;

	private List<Jury> juryList;
	private List<Participant> participantList;
	private List<Song> songList;
	private List<Gender> genderList;
	private List<Artist> artistList;

	private String selectedArtistName;
	private String selectedGenderName;

	public AdminBean() {
	}

	@PostConstruct
	public void populateLists() {
		this.juryList = this.findAllInstances("Jury.findAll", Jury.class);
		this.participantList = this.findAllInstances("Participant.findAll", Participant.class);
		this.songList = this.findAllInstances("Song.findAll", Song.class);
		this.genderList = this.findAllInstances("Gender.findAll", Gender.class);
		this.artistList = this.findAllInstances("Artist.findAll", Artist.class);
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

	public String registerJury() {
		this.jury.setGroup("jury");
		em.persist(this.jury);
		this.juryList = this.findAllInstances("Jury.findAll", Jury.class);
		return "registerJury.xhtml";
	}

	public String registerParticipant() {
		participant.setGroup("participant");
		ScoreMatrix score = new ScoreMatrix();
		score.setUsername(participant.getUsername());
		participant.setScoreMatrix(score);
		em.persist(participant);
		this.participantList = this.findAllInstances("Participant.findAll", Participant.class);
		return "registerParticipant.xhtml";
	}

	public String registerSong() {
		Artist selectedArtist = em.find(Artist.class, selectedArtistName);
		Gender selectedGender = em.find(Gender.class, selectedGenderName);
		if (selectedArtist == null || selectedGender == null)
			throw new RuntimeErrorException(null, "Alguna referencia es Null: " + "\nArtist: " + selectedArtist
					+ "\nGender: " + selectedGender);
		this.song = new Song(this.song.getTitle(), selectedArtist, selectedGender);
		em.persist(this.song);
		this.songList = this.findAllInstances("Song.findAll", Song.class);
		return "registerSong";
	}

	public String registerArtist() {
		em.persist(this.artist);
		this.artistList = this.findAllInstances("Artist.findAll", Artist.class);
		return "registerArtist.xhtml";
	}

	public String registerGender() {
		em.persist(this.gender);
		this.genderList = this.findAllInstances("Gender.findAll", Gender.class);
		return "registerGender.xhtml";
	}

	// Getters & Setters
	// --------------------------------------------------------------

	public List<Jury> getJuryList() {
		return juryList;
	}

	public void setJuryList(List<Jury> juryList) {
		this.juryList = juryList;
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}

	public List<Gender> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Gender> genderList) {
		this.genderList = genderList;
	}

	public Jury getJury() {
		return jury;
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Artist> getArtistList() {
		return artistList;
	}

	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}

	public String getSelectedGenderName() {
		return selectedGenderName;
	}

	public void setSelectedGenderName(String selectedGenderName) {
		this.selectedGenderName = selectedGenderName;
	}

	public String getSelectedArtistName() {
		return selectedArtistName;
	}

	public void setSelectedArtistName(String selectedArtistName) {
		this.selectedArtistName = selectedArtistName;
	}
}
