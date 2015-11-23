package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "presentation")
@NamedQueries({
        @NamedQuery(name = Presentation.findAll, query = "SELECT p FROM Presentation p"),
        @NamedQuery(name = Presentation.findByPresentationId, query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation")
})
public class Presentation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Presentation";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByPresentationId = PREFIX + ".findByIdPresentation";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presentation")
    private Integer idPresentation;

    @NotNull
    @Column(name = "score")
    private Float score;

    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "song")
    private String song;

    @ManyToMany(mappedBy = "presentationList")
    private List<Jury> juryList;

    @OneToMany(mappedBy = "presentation")
    private List<Participant> participantList;

    public Integer getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(Integer idPresentation) {
        this.idPresentation = idPresentation;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public List<Jury> getJuryList() {
        return juryList;
    }

    public void setJuryList(List<Jury> juryList) {
        this.juryList = juryList;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentation != null ? idPresentation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentation)) {
            return false;
        }
        Presentation other = (Presentation) object;
        if ((this.idPresentation == null && other.idPresentation != null) || (this.idPresentation != null && !this.idPresentation.equals(other.idPresentation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smorales.headbanging.entity.Presentation[ idPresentation=" + idPresentation + " ]";
    }

}
