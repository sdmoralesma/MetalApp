package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "jury")
@DiscriminatorValue("JURY")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Jury.FIND_ALL, query = "SELECT j FROM Jury j"),
        @NamedQuery(name = Jury.FIND_BY_NAME, query = "SELECT j FROM Jury j WHERE j.name = :name"),
        @NamedQuery(name = Jury.FIND__BY_USERNAME, query = "SELECT j FROM Jury j WHERE j.username = :username")})
public class Jury extends User implements Serializable {

    public static final String FIND_ALL = "Jury.findAll";
    public static final String FIND_BY_NAME = "Jury.findByName";
    public static final String FIND__BY_USERNAME = "Jury.findByUsername";
    private static final long serialVersionUID = 1L;

    @Size(max = 50)
    @Column(nullable = false, length = 100)
    private String description;

    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 100)
    private String name;

    public Jury() {
    }

    public Jury(String description, String name) {
        super();
        this.description = description;
        this.name = name;
    }

    public Jury(String username, String group_name, String password, String description, String name) {
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

    @Override
    public String toString() {
        return "Jury [description=" + description + ", name=" + name + "]";
    }
}