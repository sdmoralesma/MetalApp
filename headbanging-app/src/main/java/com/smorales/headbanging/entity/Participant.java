package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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

    @Size(max = 300)
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "participantId")
    private List<Presentation> presentationList;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "participantId")
    private List<ScoreMatrix> scoreMatrixList;

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

    public List<Presentation> getPresentationList() {
        return presentationList;
    }

    public void setPresentationList(List<Presentation> presentationList) {
        this.presentationList = presentationList;
    }

    public List<ScoreMatrix> getScoreMatrixList() {
        return scoreMatrixList;
    }

    public void setScoreMatrixList(List<ScoreMatrix> scoreMatrixList) {
        this.scoreMatrixList = scoreMatrixList;
    }
    
}
