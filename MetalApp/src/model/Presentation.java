package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the presentation database table.
 * 
 */
@Entity
public class Presentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_presentation")
	private int idPresentation;

	@Column(name="hand_score")
	private float handScore;

	@Column(name="head_score")
	private float headScore;

	@Column(name="id_jury")
	private int idJury;

	@Column(name="id_participant")
	private int idParticipant;

	@Column(name="id_song")
	private int idSong;

	@Column(name="total_score")
	private float totalScore;

	//bi-directional many-to-many association to Jury
	@ManyToMany(mappedBy="presentations")
	private List<Jury> juries;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="id_participat")
	private Participant participant;

	//bi-directional many-to-one association to Song
	@ManyToOne
	@JoinColumn(name="id_song1")
	private Song song;

	public Presentation() {
	}

	public int getIdPresentation() {
		return this.idPresentation;
	}

	public void setIdPresentation(int idPresentation) {
		this.idPresentation = idPresentation;
	}

	public float getHandScore() {
		return this.handScore;
	}

	public void setHandScore(float handScore) {
		this.handScore = handScore;
	}

	public float getHeadScore() {
		return this.headScore;
	}

	public void setHeadScore(float headScore) {
		this.headScore = headScore;
	}

	public int getIdJury() {
		return this.idJury;
	}

	public void setIdJury(int idJury) {
		this.idJury = idJury;
	}

	public int getIdParticipant() {
		return this.idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public int getIdSong() {
		return this.idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public List<Jury> getJuries() {
		return this.juries;
	}

	public void setJuries(List<Jury> juries) {
		this.juries = juries;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}