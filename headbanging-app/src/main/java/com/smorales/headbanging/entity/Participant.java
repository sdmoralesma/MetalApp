package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Participant.FIND_ALL, query = "SELECT p FROM Participant p"),
        @NamedQuery(name = Participant.FIND_BY_NAME, query = "SELECT p FROM Participant p WHERE p.name = :name"),
        @NamedQuery(name = Participant.FIND_BY_USERNAME, query = "SELECT p FROM Participant p WHERE p.username = :username")})
public class Participant extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Participant";
    public static final String FIND_ALL = PREFIX + ".findAll";
    public static final String FIND_BY_NAME = PREFIX + ".findByName";
    public static final String FIND_BY_USERNAME = PREFIX + ".findByUsername";

    @Id
    @Column(name = "participant_id")
    private Integer participantId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String username;

    @Basic(optional = false)
    @NotNull
    private int age;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String gender;

    @Size(max = 100)
    @Column(name = "image_url")
    private String imageUrl;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne
    private User userId;

    // bi-directional many-to-one association to Presentation
    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Presentation> presentations;

    // bi-directional one-to-one association to ScoreMatrix
    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ScoreMatrix scoreMatrix;

    public Participant() {
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public ScoreMatrix getScoreMatrix() {
        return scoreMatrix;
    }

    public void setScoreMatrix(ScoreMatrix scoreMatrix) {
        this.scoreMatrix = scoreMatrix;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.participantId);
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
        final Participant other = (Participant) obj;
        if (!Objects.equals(this.participantId, other.participantId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participant{" + "participantId=" + participantId + '}';
    }

}
