package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "jury")
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
    @Column(name = "jury_info")
    private String juryInfo;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "juryId")
    private Set<Presentation> presentationSet;


    public String getJuryInfo() {
        return juryInfo;
    }

    public void setJuryInfo(String juryInfo) {
        this.juryInfo = juryInfo;
    }

    public Set<Presentation> getPresentationSet() {
        return presentationSet;
    }

    public void setPresentationSet(Set<Presentation> presentationSet) {
        this.presentationSet = presentationSet;
    }
}
