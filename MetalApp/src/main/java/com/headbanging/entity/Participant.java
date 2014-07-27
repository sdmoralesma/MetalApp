package com.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "participant")
@DiscriminatorValue("PARTICIPANT")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Participant.FIND_ALL, query = "SELECT p FROM Participant p"),
        @NamedQuery(name = Participant.FIND_BY_NAME, query = "SELECT p FROM Participant p WHERE p.name = :name"),
        @NamedQuery(name = Participant.FIND_BY_USERNAME, query = "SELECT p FROM Participant p WHERE p.username = :username")})
public class Participant extends User implements Serializable {

    public static final String FIND_ALL = "Participant.findAll";
    public static final String FIND_BY_NAME = "Participant.findByName";
    public static final String FIND_BY_USERNAME = "Participant.findByUsername";
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @Min(15)
    @Max(100)
    private int age;

    @Column(nullable = false, length = 50)
    @Size(min = 5, max = 50)
    private String country;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 100)
    @Size(min = 5, max = 50)
    private String name;

    @Column(nullable = true, length = 100)
    private String image_url;

    // bi-directional many-to-one association to Presentation
    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Presentation> presentations;

    // bi-directional one-to-one association to ScoreMatrix
    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ScoreMatrix scoreMatrix;

    public Participant() {
    }

    public Participant(String username, String group_name, String password, int age, String country, String gender,
                       String name, String image_url) {
        super(username, group_name, password);
        this.age = age;
        this.country = country;
        this.gender = gender;
        this.name = name;
        this.image_url = image_url;
    }

    public Participant(int age, String country, String gender, String name, String image_url,
                       List<Presentation> presentations, ScoreMatrix scoreMatrix) {
        super();
        this.age = age;
        this.country = country;
        this.gender = gender;
        this.name = name;
        this.image_url = image_url;
        this.presentations = presentations;
        this.scoreMatrix = scoreMatrix;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Presentation> getPresentations() {
        return this.presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public Presentation addPresentation(Presentation presentation) {
        getPresentations().add(presentation);
        presentation.setParticipant(this);

        return presentation;
    }

    public Presentation removePresentation(Presentation presentation) {
        getPresentations().remove(presentation);
        presentation.setParticipant(null);

        return presentation;
    }

    public ScoreMatrix getScoreMatrix() {
        return this.scoreMatrix;
    }

    public void setScoreMatrix(ScoreMatrix scoreMatrix) {
        this.scoreMatrix = scoreMatrix;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Participant [age=" + age + ", country=" + country + ", gender=" + gender + ", name=" + name
                + ", image_url=" + image_url + ", presentations=" + presentations + ", scoreMatrix=" + scoreMatrix
                + "]";
    }
}