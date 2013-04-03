package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the presentation database table.
 * 
 */
@Entity
@Table(name = "presentation")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Presentation.findAll", query = "SELECT p FROM Presentation p"),
		@NamedQuery(name = "Presentation.findByIdPresentation", query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation"),
		@NamedQuery(name = "Presentation.findByIdParticipant", query = "SELECT p FROM Presentation p WHERE p.participant.username = :username") })
public class Presentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_presentation", unique = true, nullable = false)
	private int idPresentation;

	@Column(name = "hand_score", nullable = false)
	private float handScore;

	@Column(name = "head_score", nullable = false)
	private float headScore;

	@Column(name = "total_score", nullable = false)
	private float totalScore;

	// bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private Participant participant;

	// bi-directional many-to-one association to Song
	@ManyToOne
	@JoinColumn(name = "id_song", nullable = false)
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

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
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