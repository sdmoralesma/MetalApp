package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * The persistent class for the Users database table.
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@NamedQueries({ @NamedQuery(name = "User.findAllUsers", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findAllByType", query = "SELECT u FROM User u WHERE TYPE(u) = :type") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 50)
	@Size(min = 5, max = 25)
	private String username;

	@Column(nullable = false, length = 50)
	private String group_name;

	@Column(nullable = false, length = 50)
	@Size(min = 3, max = 20)
	private String password;

	public User() {
	}

	public User(String username, String group_name, String password) {
		super();
		this.username = username;
		this.group_name = group_name;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGroup() {
		return this.group_name;
	}

	public void setGroup(String group_name) {
		this.group_name = group_name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}