package com.metal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the artist database table.
 */
@Entity
@Table(name = "artist")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = Artist.FIND_ALL, query = "SELECT a FROM Artist a"),
		@NamedQuery(name = Artist.FIND_BY_NAME, query = "SELECT a FROM Artist a WHERE a.name = :name") })
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 50)
	private String description;

	// bi-directional many-to-one association to Song
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Song> songs;

	public static final String FIND_ALL = "Artist.findAll";
	public static final String FIND_BY_NAME = "Artist.findByName";

	public Artist() {
	}

	public Artist(String description, String name, List<Song> songs) {
		this.description = description;
		this.name = name;
		this.songs = songs;
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
		this.songs.add(song);
		song.setArtist(this);
		return song;
	}

	public Song removeSong(Song song) {
		this.songs.remove(song);
		song.setArtist(null);
		return song;
	}

	@Override
	public String toString() {
		return "Artist [description=" + description + ", name=" + name + ", songs=" + songs + "]";
	}
}