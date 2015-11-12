package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "presentation")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Presentation.findAll, query = "SELECT p FROM Presentation p"),
        @NamedQuery(name = Presentation.findByPresentationId, query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation"),
        @NamedQuery(name = Presentation.findByParticipantId, query = "SELECT p FROM Presentation p WHERE p.participant.username = :username")
})
public class Presentation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Presentation";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByPresentationId = PREFIX + ".findByIdPresentation";
    public static final String findByParticipantId = PREFIX + ".findByIdParticipant";

    @Id
    @Column
    @GeneratedValue
    private Integer idPresentation;

    @Basic(optional = false)
    @NotNull
    private float score;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    private String song;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;

    // bi-directional many-to-one association to Participant
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Participant participant;

    // bi-directional many-to-one association to Song
    public Presentation() {
    }

    public Integer getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(Integer idPresentation) {
        this.idPresentation = idPresentation;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idPresentation);
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
        final Presentation other = (Presentation) obj;
        if (!Objects.equals(this.idPresentation, other.idPresentation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Presentation{" + "idPresentation=" + idPresentation + '}';
    }

}
