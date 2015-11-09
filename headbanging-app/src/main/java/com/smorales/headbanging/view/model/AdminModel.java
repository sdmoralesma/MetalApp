package com.smorales.headbanging.view.model;

import com.smorales.headbanging.entity.*;

import javax.inject.Named;

@Named
public class AdminModel {

    private Admin admin;
    private Jury jury;
    private Participant participant;
    private Song song;
    private Gender gender;
    private Artist artist;
    private String selectedArtistName;
    private String selectedGenderName;


    // Getters / Setters

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
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

    public String getSelectedArtistName() {
        return selectedArtistName;
    }

    public void setSelectedArtistName(String selectedArtistName) {
        this.selectedArtistName = selectedArtistName;
    }

    public String getSelectedGenderName() {
        return selectedGenderName;
    }

    public void setSelectedGenderName(String selectedGenderName) {
        this.selectedGenderName = selectedGenderName;
    }
}
