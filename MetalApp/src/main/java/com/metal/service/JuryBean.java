package com.metal.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;
import com.metal.model.Song;
import com.metal.model.SongMatrix;

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
	@Inject 
	private SongMatrix matrix;

	private List<Participant> participantList;
	private List<Song> songList;
	private List<SongMatrix> matrixList;
	private Integer musicalityPoints;
	private Integer compositionPoints;
	private Integer handPoints;
	private Integer headPoints;

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

	public void votePerParticipant() {
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findByUsername", Participant.class)
				.setParameter("username", participant.getUsername());

		List<Participant> participants = query.getResultList();
		if (participants.isEmpty()) {
			FacesMessage msg = new FacesMessage("The participant does not exists");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		System.out.println("The Participant: " + participants.get(0).getName());

		TypedQuery<ScoreMatrix> scoreQuery = em.createNamedQuery("ScoreMatrix.findByUsername", ScoreMatrix.class)
				.setParameter("username", participant.getUsername());

		List<ScoreMatrix> scoreMatrix = scoreQuery.getResultList();
		if (scoreMatrix.isEmpty()) {
			FacesMessage msg = new FacesMessage("The participant does not exists");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} else {
			
		    ScoreMatrix score = scoreMatrix.get(0);
			score.setTotalScore(score.getTotalScore() + 1);
			participant.setScoreMatrix(score);
			em.persist(participant);

			FacesMessage msg = new FacesMessage("The Vote has been Registered, Thanks!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void votePerSong() {
		TypedQuery<Song> query = em.createNamedQuery("Song.findByTitle", Song.class).setParameter("title",
				song.getTitle());
		List<Song> songs = query.getResultList();
		if (songs.isEmpty()) {
			FacesMessage msg = new FacesMessage("The song does not exists");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// throw new IllegalArgumentException("The song does not exists");
			// // Add exception Handler
		} else {

			Song theSongToVote = songs.get(0);
			SongMatrix songMatrix = theSongToVote.getSongMatrix();
			if (songMatrix == null) {
				songMatrix = new SongMatrix();
				songMatrix.setSong(theSongToVote);
			}
			
			songMatrix = addCompositionPointsToSongMatrix(songMatrix, compositionPoints);
			songMatrix = addMusicalityPoinstToSongMatrix(songMatrix, musicalityPoints);			
			theSongToVote.setSongMatrix(songMatrix);
			
			em.persist(theSongToVote);
			FacesMessage msg = new FacesMessage("The Vote has been Registered, Thanks!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	private SongMatrix addCompositionPointsToSongMatrix(SongMatrix songMatrix, Integer points) {

		Integer totalPunctuation;

		switch (points) {
		case 1:
			totalPunctuation = (songMatrix.getComposition1() + 1);
			songMatrix.setComposition1(totalPunctuation);
			break;
		case 2:
			totalPunctuation = (songMatrix.getComposition2() + 1);
			songMatrix.setComposition2(totalPunctuation);
			break;
		case 3:
			totalPunctuation = (songMatrix.getComposition3() + 1);
			songMatrix.setComposition3(totalPunctuation);
			break;
		case 4:
			totalPunctuation = (songMatrix.getComposition4() + 1);
			songMatrix.setComposition4(totalPunctuation);
			break;
		case 5:
			totalPunctuation = (songMatrix.getComposition5() + 1);
			songMatrix.setComposition5(totalPunctuation);
			break;
		case 6:
			totalPunctuation = (songMatrix.getComposition6() + 1);
			songMatrix.setComposition6(totalPunctuation);
			break;
		case 7:
			totalPunctuation = (songMatrix.getComposition7() + 1);
			songMatrix.setComposition7(totalPunctuation);
			break;
		case 8:
			totalPunctuation = (songMatrix.getComposition8() + 1);
			songMatrix.setComposition8(totalPunctuation);
			break;
		case 9:
			totalPunctuation = (songMatrix.getComposition9() + 1);
			songMatrix.setComposition9(totalPunctuation);
			break;
		case 10:
			totalPunctuation = (songMatrix.getComposition10() + 1);
			songMatrix.setComposition10(totalPunctuation);
			break;

		default:
			break;
		}
		return songMatrix;
	}

	private SongMatrix addMusicalityPoinstToSongMatrix(SongMatrix songMatrix, Integer points) {

		Integer totalPunctuation;
		switch (points) {
		case 1:
			totalPunctuation = (songMatrix.getMusicality1() + 1);
			songMatrix.setMusicality1(totalPunctuation);
			break;
		case 2:
			totalPunctuation = (songMatrix.getMusicality2() + 1);
			songMatrix.setMusicality2(totalPunctuation);
			break;
		case 3:
			totalPunctuation = (songMatrix.getMusicality3() + 1);
			songMatrix.setMusicality3(totalPunctuation);
			break;
		case 4:
			totalPunctuation = (songMatrix.getMusicality4() + 1);
			songMatrix.setMusicality4(totalPunctuation);
			break;
		case 5:
			totalPunctuation = (songMatrix.getMusicality5() + 1);
			songMatrix.setMusicality5(totalPunctuation);
			break;
		case 6:
			totalPunctuation = (songMatrix.getMusicality6() + 1);
			songMatrix.setMusicality6(totalPunctuation);
			break;
		case 7:
			totalPunctuation = (songMatrix.getMusicality7() + 1);
			songMatrix.setMusicality7(totalPunctuation);
			break;
		case 8:
			totalPunctuation = (songMatrix.getMusicality8() + 1);
			songMatrix.setMusicality8(totalPunctuation);
			break;
		case 9:
			totalPunctuation = (songMatrix.getMusicality9() + 1);
			songMatrix.setMusicality9(totalPunctuation);
			break;
		case 10:
			totalPunctuation = (songMatrix.getMusicality10() + 1);
			songMatrix.setMusicality10(totalPunctuation);
			break;

		default:
			break;
		}

		return songMatrix;

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

	public Integer getMusicalityPoints() {
		return musicalityPoints;
	}

	public void setMusicalityPoints(Integer musicalityPoints) {
		this.musicalityPoints = musicalityPoints;
	}

	public Integer getCompositionPoints() {
		return compositionPoints;
	}

	public void setCompositionPoints(Integer compositionPoints) {
		this.compositionPoints = compositionPoints;
	}

	public Integer getHandPoints() {
		return handPoints;
	}

	public void setHandPoints(Integer handPoints) {
		this.handPoints = handPoints;
	}

	public Integer getHeadPoints() {
		return headPoints;
	}

	public void setHeadPoints(Integer headPoints) {
		this.headPoints = headPoints;
	}

	public SongMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(SongMatrix matrix) {
		this.matrix = matrix;
	}

	public List<SongMatrix> getMatrixList() {
		return matrixList;
	}

	public void setMatrixList(List<SongMatrix> matrixList) {
		this.matrixList = matrixList;
	}
}
