package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * The persistent class for the participant database table.
 * 
 */
@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Participant.findAll", query = "SELECT p FROM Participant p"),
		@NamedQuery(name = "Participant.findByName", query = "SELECT p FROM Participant p WHERE p.name = :name"),
		@NamedQuery(name = "Participant.findByUsername", query = "SELECT p FROM Participant p WHERE p.username = :username") })
public class Participant extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Column(unique=true, nullable=false, length=50)
	// private String username;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false, length = 50)
	private String country;

	@Column(nullable = false, length = 50)
	private String gender;

	@Column(nullable = false, length = 100)
	private String name;

	// bi-directional one-to-one association to User
	// @OneToOne
	// @JoinColumn(name="username", nullable=false, insertable=false,
	// updatable=false)
	// private User user;

	// bi-directional many-to-one association to Presentation
	@OneToMany(mappedBy = "participant", cascade = CascadeType.PERSIST)
	private List<Presentation> presentations;

	// bi-directional one-to-one association to ScoreMatrix
	@OneToOne(mappedBy = "participant", cascade = CascadeType.PERSIST)
	private ScoreMatrix scoreMatrix;

	public Participant() {
	}

	// public String getUsername() {
	// return this.username;
	// }
	//
	// public void setUsername(String username) {
	// this.username = username;
	// }

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public User getUser() {
	// return this.user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

	public List<Presentation> getPresentations() {
		return this.presentations;
	}

	public void setPresentations(List<Presentation> presentations) {
		this.presentations = presentations;
	}

	public Presentation addPresentation(Presentation presentation) {
		getPresentations().add(presentation);
		presentation.setParticipant(this);

		return presentation;
	}

	public Presentation removePresentation(Presentation presentation) {
		getPresentations().remove(presentation);
		presentation.setParticipant(null);

		return presentation;
	}

	public ScoreMatrix getScoreMatrix() {
		return this.scoreMatrix;
	}

	public void setScoreMatrix(ScoreMatrix scoreMatrix) {
		this.scoreMatrix = scoreMatrix;
	}

	@Override
	public String toString() {
		return "Participant [age=" + age + ", country=" + country + ", gender=" + gender + ", name=" + name
				+ ", presentations=" + presentations + ", scoreMatrix=" + scoreMatrix + "]";
	}
}