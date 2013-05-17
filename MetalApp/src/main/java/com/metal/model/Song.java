package com.metal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the song database table.
 */
@Entity
@Table(name = "song")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
		@NamedQuery(name = "Song.findByTitle", query = "SELECT s FROM Song s WHERE s.title = :title"),
		@NamedQuery(name = "Song.findByIdArtist", query = "SELECT s FROM Song s WHERE s.artist = :idArtist"),
		@NamedQuery(name = "Song.findByIdGender", query = "SELECT s FROM Song s WHERE s.gender = :idGender") })
public class Song implements Serializable {
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