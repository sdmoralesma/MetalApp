package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the jury database table.
 */
@Entity
@Table(name = "jury")
@DiscriminatorValue("JURY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Jury.findAll", query = "SELECT j FROM Jury j"),
		@NamedQuery(name = "Jury.findByName", query = "SELECT j FROM Jury j WHERE j.name = :name"),
		@NamedQuery(name = "Jury.findByUsername", query = "SELECT j FROM Jury j WHERE j.username = :username") })
public class Jury extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Size(max = 50)
	@Column(nullable = false, length = 100)
	private String description;

	@Size(min = 5, max = 50)
	@Column(nullable = false, length = 100)
	private String name;

	public Jury() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Jury [description=" + description + ", name=" + name + "]";
	}
}