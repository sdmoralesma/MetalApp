package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "jury")
@DiscriminatorValue("JURY")
@PrimaryKeyJoinColumn(name = "jury_id", referencedColumnName = "user_id")
@NamedQueries({
        @NamedQuery(name = Jury.findAll, query = "SELECT j FROM Jury j"),
        @NamedQuery(name = Jury.findByName, query = "SELECT j FROM Jury j WHERE j.name = :name"),
        @NamedQuery(name = Jury.findByUsername, query = "SELECT j FROM Jury j WHERE j.username = :username")
})
public class Jury extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Jury";
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


    public Jury() {
    }

    public Jury(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
