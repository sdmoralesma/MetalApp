package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
@PrimaryKeyJoinColumn(name = "participant_id", referencedColumnName = "user_id")
public class Participant extends User implements Serializable {

    private static final long serialVersionUID = 1L;

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
