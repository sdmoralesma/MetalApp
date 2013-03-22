package com.metal.managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.metal.ejb.FacadeEJB;
import com.metal.model.Song;

@ManagedBean
@RequestScoped
public class BeanSong {

	@EJB
	private FacadeEJB facade;

	private Song song = new Song();
	private List<Song> songList = new ArrayList<>();

	public String doVotePerSong() {
		facade.registerVotePerSong(song);
		// songList = facade.find();
		return "votePerSong.xhtml";
	}

	public String doCreateSong() {
		facade.registerSong(song);
		// songList = facade.find();
		return "registerSong.xhtml";
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
}
