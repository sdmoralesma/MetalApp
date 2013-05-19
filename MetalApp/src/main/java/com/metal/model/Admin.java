package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the admin database table.
 */
@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = Admin.FIND_ALL, query = "SELECT a FROM Admin a"),
		@NamedQuery(name = Admin.FIND_BY_NAME, query = "SELECT a FROM Admin a WHERE a.name = :name"),
		@NamedQuery(name = Admin.FIND_BY_USERNAME, query = "SELECT a FROM Admin a WHERE a.username = :username") })
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Size(max = 50)
	@Column(nullable = false, length = 100)
	private String description;

	@Size(min = 5, max = 50)
	@Column(nullable = false, length = 100)
	private String name;

	public static final String FIND_ALL = "Admin.findAll";
	public static final String FIND_BY_NAME = "Admin.findByName";
	public static final String FIND_BY_USERNAME = "Admin.findByUsername";

	public Admin() {
	}

	public Admin(String description, String name) {
		this.description = description;
		this.name = name;
	}

	public Admin(String username, String group_name, String password, String description, String name) {
		super(username, group_name, password);
		this.description = description;
		this.name = name;
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
}