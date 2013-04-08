package com.metal.managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.metal.ejb.FacadeEJB;
import com.metal.model.Artist;
import com.metal.model.Gender;
import com.metal.model.Song;

@ManagedBean
@RequestScoped
public class BeanSong {

	@EJB
	private FacadeEJB facade;

	private Song song = new Song();
	private Gender gender = new Gender();
	private Artist artist = new Artist();
	private List<Song> songList = new ArrayList<>();

	@PostConstruct
	public void populateSongList() {
		this.songList = facade.findSongs();
	}
	
	public String doCreateSong() {
		song.setArtist(artist);
		song.setGender(gender);
		facade.registerSong(song);
		songList = facade.findSongs();
		return "registerSong.xhtml";
	}
	
	public String doVotePerSong() {
		facade.registerVotePerSong(song);
		songList = facade.findSongs();
		return "votePerSong.xhtml";
	}

	// Getters y Setters
	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
	
}
