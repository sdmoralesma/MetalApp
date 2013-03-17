package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gender database table.
 * 
 */
@Entity
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_gender")
	private int idGender;

	@Column(name="hang_value")
	private int hangValue;

	@Column(name="head_value")
	private int headValue;

	private String name;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="gender")
	private List<Song> songs;

	public Gender() {
	}

	public int getIdGender() {
		return this.idGender;
	}

	public void setIdGender(int idGender) {
		this.idGender = idGender;
	}

	public int getHangValue() {
		return this.hangValue;
	}

	public void setHangValue(int hangValue) {
		this.hangValue = hangValue;
	}

	public int getHeadValue() {
		return this.headValue;
	}

	public void setHeadValue(int headValue) {
		this.headValue = headValue;
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
		song.setGender(this);

		return song;
	}

	public Song removeSong(Song song) {
		getSongs().remove(song);
		song.setGender(null);

		return song;
	}

}