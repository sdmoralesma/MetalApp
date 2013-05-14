package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;

/**
 * The persistent class for the gender database table.
 * 
 */
@Entity
@Table(name = "gender")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g"),
		@NamedQuery(name = "Gender.findByName", query = "SELECT g FROM Gender g WHERE g.name = :name") })
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 50)
	private String name;

	@Column(name = "hand_value", nullable = false)
	private int handValue;

	@Column(name = "head_value", nullable = false)
	private int headValue;

	// bi-directional many-to-one association to Song
	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	private List<Song> songs;

	public Gender() {
	}

	public Gender(String name, int handValue, int headValue, List<Song> songs) {
		this.name = name;
		this.handValue = handValue;
		this.headValue = headValue;
		this.songs = songs;
	}

	public int getHandValue() {
		return this.handValue;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
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

	@XmlTransient
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

	@Override
	public String toString() {
		return "Gender [name=" + name + ", handValue=" + handValue + ", headValue=" + headValue + ", songs=" + songs
				+ "]";
	}
}