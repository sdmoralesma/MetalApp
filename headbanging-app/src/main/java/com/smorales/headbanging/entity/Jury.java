package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "jury")
@DiscriminatorValue("JURY")
@PrimaryKeyJoinColumn(name = "jury_id")
@NamedQueries({
        @NamedQuery(name = Jury.findAll, query = "Select j from Jury j"),
        @NamedQuery(name = Jury.findByUsername, query = "SELECT j FROM Jury j WHERE j.username=:username"),
})
public class Jury extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Jury";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByUsername = PREFIX + ".findByUsername";

    @Size(max = 100)
    @Column(name = "jury_info")
    private String juryInfo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juryId")
    private List<Qualifications> qualificationsList;

    public String getJuryInfo() {
        return juryInfo;
    }

    public void setJuryInfo(String juryInfo) {
        this.juryInfo = juryInfo;
    }

    public List<Qualifications> getQualificationsList() {
        return qualificationsList;
    }

    public void setQualificationsList(List<Qualifications> qualificationsList) {
        this.qualificationsList = qualificationsList;
    }

}
