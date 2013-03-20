package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jury database table.
 * 
 */
@Entity
@Table(name="jury")
public class Jury implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jury", unique=true, nullable=false)
	private int idJury;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, length=50)
	private String password;

	@Column(nullable=false, length=50)
	private String username;

	//bi-directional many-to-many association to Presentation
	@ManyToMany
	@JoinTable(
		name="jury_presentation"
		, joinColumns={
			@JoinColumn(name="jury_id_jury", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="presentation_id_presentation", nullable=false)
			}
		)
	private List<Presentation> presentations;

	public Jury() {
	}

	public int getIdJury() {
		return this.idJury;
	}

	public void setIdJury(int idJury) {
		this.idJury = idJury;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Presentation> getPresentations() {
		return this.presentations;
	}

	public void setPresentations(List<Presentation> presentations) {
		this.presentations = presentations;
	}

}