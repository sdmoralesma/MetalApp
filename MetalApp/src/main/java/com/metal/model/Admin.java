package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
		@NamedQuery(name = "Admin.findByName", query = "SELECT a FROM Admin a WHERE a.name = :name"),
		@NamedQuery(name = "Admin.findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username") })
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Column(unique=true, nullable=false, length=50)
	// private String username;

	@Column(nullable = false, length = 100)
	private String description;

	@Column(nullable = false, length = 100)
	private String name;

	// bi-directional one-to-one association to User
	// @OneToOne
	// @JoinColumn(name="username", nullable=false, insertable=false,
	// updatable=false)
	// private User user;

	public Admin() {
	}

	// public String getUsername() {
	// return this.username;
	// }
	//
	// public void setUsername(String username) {
	// this.username = username;
	// }

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

	// public User getUser() {
	// return this.user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

}