package com.metal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
		@NamedQuery(name = "Song.findByIdSong", query = "SELECT s FROM Song s WHERE s.idSong = :idSong"),
		@NamedQuery(name = "Song.findByTitle", query = "SELECT s FROM Song s WHERE s.title = :title"),
		@NamedQuery(name = "Song.findByIdArtist", query = "SELECT s FROM Song s WHERE s.artist = :idArtist"),
		@NamedQuery(name = "Song.findByIdGender", query = "SELECT s FROM Song s WHERE s.gender = :idGender") })
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_song", unique = true, nullable = false)
	private int idSong;

	@Column(nullable = false, length = 100)
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
	@OneToOne(mappedBy = "song")
	private SongMatrix songMatrix;

	public Song() {
	}

	public int getIdSong() {
		return this.idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
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
		return "Song [idSong=" + idSong + ", title=" + title + ", presentations=" + presentations + ", artist="
				+ artist + ", gender=" + gender + ", songMatrix=" + songMatrix + "]";
	}
}