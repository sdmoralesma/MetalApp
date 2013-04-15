package com.metal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the artist database table.
 * 
 */
@Entity
@Table(name = "artist")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
		@NamedQuery(name = "Artist.findByIdArtist", query = "SELECT a FROM Artist a WHERE a.idArtist = :idArtist"),
		@NamedQuery(name = "Artist.findByName", query = "SELECT a FROM Artist a WHERE a.name = :name") })
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_artist", unique = true, nullable = false)
	private int idArtist;

	@Column(nullable = false, length = 50)
	private String description;

	@Column(nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to Song
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Song> songs;

	public Artist() {
	}

	public int getIdArtist() {
		return this.idArtist;
	}

	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Song addSong(Song song) {
		getSongs().add(song);
		song.setArtist(this);

		return song;
	}

	public Song removeSong(Song song) {
		getSongs().remove(song);
		song.setArtist(null);

		return song;
	}

	@Override
	public String toString() {
		return "Artist [idArtist=" + idArtist + ", description=" + description + ", name=" + name + "]";
	}

}