package com.headbanging.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "song")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = Song.FIND_ALL, query = "SELECT s FROM Song s"),
        @NamedQuery(name = Song.FIND_BY_TITLE, query = "SELECT s FROM Song s WHERE s.title = :title"),
        @NamedQuery(name = Song.FIND_BY_ID_ARTIST, query = "SELECT s FROM Song s WHERE s.artist = :idArtist"),
        @NamedQuery(name = Song.FIND_BY_ID_GENDER, query = "SELECT s FROM Song s WHERE s.gender = :idGender")})
public class Song implements Serializable {

    public static final String FIND_ALL = "Song.findAll";
    public static final String FIND_BY_TITLE = "Song.findByTitle";
    public static final String FIND_BY_ID_ARTIST = "Song.findByIdArtist";
    public static final String FIND_BY_ID_GENDER = "Song.findByIdGender";
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 100)
    private String title;

    // bi-directional many-to-one association to Presentation
    @OneToMany(mappedBy = "song")
    private List<Presentation> presentations;

    // bi-directional many-to-one association to Artist
    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist artist;

    // bi-directional many-to-one association to Gender
    @ManyToOne
    @JoinColumn(name = "id_gender", nullable = false)
    private Gender gender;

    // bi-directional one-to-one association to SongMatrix
    @OneToOne(mappedBy = "song", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SongMatrix songMatrix;

    public Song() {
    }

    public Song(String title, Artist artist, Gender gender) {
        this.title = title;
        this.artist = artist;
        this.gender = gender;
    }

    public Song(String title, List<Presentation> presentations, Artist artist, Gender gender, SongMatrix songMatrix) {
        this.title = title;
        this.presentations = presentations;
        this.artist = artist;
        this.gender = gender;
        this.songMatrix = songMatrix;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Presentation> getPresentations() {
        return this.presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public Presentation addPresentation(Presentation presentation) {
        this.presentations.add(presentation);
        presentation.setSong(this);
        return presentation;
    }

    public Presentation removePresentation(Presentation presentation) {
        this.presentations.remove(presentation);
        presentation.setSong(null);
        return presentation;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public SongMatrix getSongMatrix() {
        return this.songMatrix;
    }

    public void setSongMatrix(SongMatrix songMatrix) {
        this.songMatrix = songMatrix;
    }

    @Override
    public String toString() {
        return "Song [title=" + title + ", artist=" + artist + ", gender=" + gender + "]";
    }
}