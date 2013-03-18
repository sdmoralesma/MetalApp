package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the presentation database table.
 * 
 */
@Entity
@Table(name="presentation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentation.findAll", query = "SELECT p FROM Presentation p"),
    @NamedQuery(name = "Presentation.findByIdPresentation", query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation"),
    @NamedQuery(name = "Presentation.findByIdParticipant", query = "SELECT p FROM Presentation p WHERE p.idParticipant = :idParticipant"),
    @NamedQuery(name = "Presentation.findByIdSong", query = "SELECT p FROM Presentation p WHERE p.idSong = :idSong"),
    @NamedQuery(name = "Presentation.findByIdJury", query = "SELECT p FROM Presentation p WHERE p.idJury = :idJury"),
    @NamedQuery(name = "Presentation.findByHandScore", query = "SELECT p FROM Presentation p WHERE p.handScore = :handScore"),
    @NamedQuery(name = "Presentation.findByHeadScore", query = "SELECT p FROM Presentation p WHERE p.headScore = :headScore"),
    @NamedQuery(name = "Presentation.findByTotalScore", query = "SELECT p FROM Presentation p WHERE p.totalScore = :totalScore")})
public class Presentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_presentation", unique=true, nullable=false)
	private int idPresentation;

	@Column(name="hand_score", nullable=false)
	private float handScore;

	@Column(name="head_score", nullable=false)
	private float headScore;

	@Column(name="id_jury", nullable=false)
	private int idJury;

	@Column(name="id_participant", nullable=false)
	private int idParticipant;

	@Column(name="id_song", nullable=false)
	private int idSong;

	@Column(name="total_score", nullable=false)
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