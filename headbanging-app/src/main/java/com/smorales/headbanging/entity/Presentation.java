package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "presentation")
@NamedQueries({
        @NamedQuery(name = Presentation.findAll, query = "SELECT p FROM Presentation p"),
        @NamedQuery(name = Presentation.findByPresentationId, query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation"),
        @NamedQuery(name = Presentation.findByParticipantId, query = "SELECT p FROM Presentation p WHERE p.participantId.username = :username")
})
public class Presentation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Presentation";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByPresentationId = PREFIX + ".findByIdPresentation";
    public static final String findByParticipantId = PREFIX + ".findByIdParticipant";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idPresentation;

    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private float score;

    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "song")
    private String song;

    @JoinColumn(name = "jury_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Jury juryId;

    @JoinColumn(name = "participant_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Participant participantId;


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

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Jury getJuryId() {
        return juryId;
    }

    public void setJuryId(Jury juryId) {
        this.juryId = juryId;
    }

    public Participant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Participant participantId) {
        this.participantId = participantId;
    }    
}
