package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Admin.findAll, query = "SELECT a FROM Admin a"),
        @NamedQuery(name = Admin.findByName, query = "SELECT a FROM Admin a WHERE a.name = :name"),
        @NamedQuery(name = Admin.findByUsername, query = "SELECT a FROM Admin a WHERE a.username = :username")
})
public class Admin extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Admin";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByName = PREFIX + ".findByName";
    public static final String findByUsername = PREFIX + ".findByUsername";

    @Id
    @Column(name = "admin_id")
    private Integer adminId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String description;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne
    private User userId;

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

    public Admin(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.adminId, other.adminId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smorales.headbanging.entity.Admin[ adminId=" + adminId + " ]";
    }
}
