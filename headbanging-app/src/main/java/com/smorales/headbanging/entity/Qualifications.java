package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "qualifications")
@NamedQueries({
        @NamedQuery(name = "Qualifications.findAll", query = "SELECT q FROM Qualifications q")})
public class Qualifications implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_qualification")
    private Integer idQualification;

    @NotNull
    @Column(name = "score")
    private Integer score;

    @JoinColumn(name = "jury_id", referencedColumnName = "jury_id")
    @ManyToOne(optional = false)
    private Jury juryId;

    @JoinColumn(name = "participant_id", referencedColumnName = "participant_id")
    @ManyToOne(optional = false)
    private Participant participantId;

    public Integer getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQualification != null ? idQualification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualifications)) {
            return false;
        }
        Qualifications other = (Qualifications) object;
        if ((this.idQualification == null && other.idQualification != null) || (this.idQualification != null && !this.idQualification.equals(other.idQualification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smorales.headbanging.entity.Qualifications[ idQualification=" + idQualification + " ]";
    }

}
