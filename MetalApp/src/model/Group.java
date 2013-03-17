package model;

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

	@Column(name="id_group")
	private String idGroup;

	@Id
	private String username;

	public Group() {
	}

	public String getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}