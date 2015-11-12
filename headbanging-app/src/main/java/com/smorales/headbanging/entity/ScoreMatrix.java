package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "score_matrix")
@XmlRootElement
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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String username;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;

    // bi-directional one-to-one association to Participant
    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private Participant participant;

    public ScoreMatrix() {
    }

    public ScoreMatrix(Participant participant) {
        this.participant = participant;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idScoreMatrix);
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
        final ScoreMatrix other = (ScoreMatrix) obj;
        if (!Objects.equals(this.idScoreMatrix, other.idScoreMatrix)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScoreMatrix{" + "idScoreMatrix=" + idScoreMatrix + '}';
    }

}
