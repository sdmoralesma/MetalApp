package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "presentation")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Presentation.FIND_ALL, query = "SELECT p FROM Presentation p"),
        @NamedQuery(name = Presentation.FIND_BY_ID_PRESENTATION, query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation"),
        @NamedQuery(name = Presentation.FIND_BY_ID_PARTICIPANT, query = "SELECT p FROM Presentation p WHERE p.participant.username = :username")})
public class Presentation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Presentation.findAll";
    public static final String FIND_BY_ID_PRESENTATION = "Presentation.findByIdPresentation";
    public static final String FIND_BY_ID_PARTICIPANT = "Presentation.findByIdParticipant";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presentation", unique = true, nullable = false)
    private int idPresentation;

    @Column(name = "hand_score", nullable = false)
    private float handScore;

    @Column(name = "head_score", nullable = false)
    private float headScore;

    @Column(name = "total_score", nullable = false)
    private float totalScore;

    @Column
    @Max(300)
    private String song;

    // bi-directional many-to-one association to Participant
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Participant participant;

    // bi-directional many-to-one association to Song

    public Presentation() {
    }

    public Presentation(int idPresentation, float handScore, float headScore, float totalScore, Participant participant, String song) {
        this.idPresentation = idPresentation;
        this.handScore = handScore;
        this.headScore = headScore;
        this.totalScore = totalScore;
        this.participant = participant;
        this.song = song;
    }

    public int getIdPresentation() {
        return this.idPresentation;
    }

    public void setIdPresentation(int idPresentation) {
        this.idPresentation = idPresentation;
    }

    public float getHandScore() {
        return this.handScore;
    }

    public void setHandScore(float handScore) {
        this.handScore = handScore;
    }

    public float getHeadScore() {
        return this.headScore;
    }

    public void setHeadScore(float headScore) {
        this.headScore = headScore;
    }

    public float getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getSong() {
        return this.song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Presentation [idPresentation=" + idPresentation + ", handScore=" + handScore + ", headScore="
                + headScore + ", totalScore=" + totalScore + ", participant=" + participant + ", song=" + song + "]";
    }
}