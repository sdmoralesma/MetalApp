package com.smorales.headbanging.presentation.model;

import com.smorales.headbanging.entity.Admin;
import com.smorales.headbanging.entity.Jury;
import com.smorales.headbanging.entity.Participant;

import javax.inject.Named;

@Named
public class AdminModel {

    private Admin admin;
    private Jury jury;
    private Participant participant;
    private String song;
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

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
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
