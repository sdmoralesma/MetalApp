package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
@PrimaryKeyJoinColumn(name = "participant_id", referencedColumnName = "user_id")
@NamedQueries({
        @NamedQuery(name = Participant.findByUsername, query = "SELECT p FROM Participant p WHERE p.username=:username"),
        @NamedQuery(name = Participant.findAll, query = "SELECT p FROM Participant p")

})
public class Participant extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Participant";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByUsername = PREFIX + ".findByUsername";


    @NotNull
    @Column(name = "age")
    @Size(min = 16, max = 100)
    private int age;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Size(max = 300)
    @Column(name = "image_url")
    private String imageUrl;

    @JoinColumn(name = "presentation_id", referencedColumnName = "id_presentation")
    @ManyToOne(optional = false)
    private Presentation presentation;

    @JoinColumn(name = "score_matrix_id", referencedColumnName = "id_score_matrix")
    @ManyToOne(optional = false)
    private ScoreMatrix scoreMatrix;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentationId) {
        this.presentation = presentationId;
    }

    public ScoreMatrix getScoreMatrix() {
        return scoreMatrix;
    }

    public void setScoreMatrix(ScoreMatrix scoreMatrixId) {
        this.scoreMatrix = scoreMatrixId;
    }

}
