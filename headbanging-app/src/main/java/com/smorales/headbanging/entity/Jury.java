package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "jury")
@DiscriminatorValue("JURY")
@XmlRootElement
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

    @Id
    @Column(name = "jury_id")
    private Integer juryId;

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

    public Jury() {
    }

    public Jury(Integer juryId) {
        this.juryId = juryId;
    }

    public Jury(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Integer getJuryId() {
        return juryId;
    }

    public void setJuryId(Integer juryId) {
        this.juryId = juryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.juryId);
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
        final Jury other = (Jury) obj;
        if (!Objects.equals(this.juryId, other.juryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smorales.headbanging.entity.Jury[ juryId=" + juryId + " ]";
    }
}
