package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
@PrimaryKeyJoinColumn(name = "participant_id", referencedColumnName = "user_id")
@NamedQueries({
        @NamedQuery(name = Participant.findAll, query = "SELECT p FROM Participant p"),
        @NamedQuery(name = Participant.findByUsername, query = "SELECT p FROM Participant p WHERE p.username=:username"),
        @NamedQuery(name = Participant.findByUsernameLike, query = "SELECT p FROM Participant p WHERE p.username LIKE :query")
})
public class Participant extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Participant";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByUsername = PREFIX + ".findByUsername";
    public static final String findByUsernameLike = PREFIX + ".findByUsernameLike";

    @Min(16)
    @Max(100)
    @Column(name = "age")
    private Integer age;

    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Size(max = 300)
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "total_score")
    private Double totalScore;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participantId")
    private List<Qualifications> qualificationsList;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public List<Qualifications> getQualificationsList() {
        return qualificationsList;
    }

    public void setQualificationsList(List<Qualifications> qualificationsList) {
        this.qualificationsList = qualificationsList;
    }

}
