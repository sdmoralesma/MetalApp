package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName = "user_id")
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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String description;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

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
