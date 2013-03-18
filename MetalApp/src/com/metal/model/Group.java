package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=50)
	private String username;

	@Column(name="id_group", length=50)
	private String idGroup;

	public Group() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}

}