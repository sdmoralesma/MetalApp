package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
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

    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "participantId")
    private ScoreMatrix scoreMatrixSet;

    @Size(max = 100)
    @Column(name = "image_url")
    private String imageUrl;

    // bi-directional many-to-one association to Presentation
    @OneToOne(mappedBy = "participantId", cascade = CascadeType.PERSIST)
    private Presentation presentations;

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

    public ScoreMatrix getScoreMatrixSet() {
        return scoreMatrixSet;
    }

    public void setScoreMatrixSet(ScoreMatrix scoreMatrixSet) {
        this.scoreMatrixSet = scoreMatrixSet;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Presentation getPresentations() {
        return presentations;
    }

    public void setPresentations(Presentation presentations) {
        this.presentations = presentations;
    }
}
