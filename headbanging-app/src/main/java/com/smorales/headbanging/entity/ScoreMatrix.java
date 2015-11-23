package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "score_matrix")
@NamedQueries({
        @NamedQuery(name = ScoreMatrix.findAll, query = "SELECT s FROM ScoreMatrix s"),
        @NamedQuery(name = ScoreMatrix.findByUsername, query = "SELECT s FROM ScoreMatrix s WHERE s.idScoreMatrix = :username")
})
public class ScoreMatrix implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "ScoreMatrix";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByUsername = PREFIX + ".findByUsername";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score_matrix")
    private Integer idScoreMatrix;

    @NotNull
    @Column(name = "total_score")
    private Float totalScore;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "scoreMatrix")
    private Participant participant;

    public Integer getIdScoreMatrix() {
        return idScoreMatrix;
    }

    public void setIdScoreMatrix(Integer idScoreMatrix) {
        this.idScoreMatrix = idScoreMatrix;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    public ScoreMatrix() {
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

}
