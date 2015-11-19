package com.smorales.headbanging.entity;

import javax.persistence.*;
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

    @Column(name = "total_score")
    private Float totalScore;

    @JoinColumn(name = "participant_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Participant participantId;

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

    public Participant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Participant participantId) {
        this.participantId = participantId;
    }
}
