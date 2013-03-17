package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artist database table.
 * 
 */
@Entity
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_artist")
	private int idArtist;

	private String name;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="artist")
	private List<Song> songs;

	public Artist() {
	}

	public int getIdArtist() {
		return this.idArtist;
	}

	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

}