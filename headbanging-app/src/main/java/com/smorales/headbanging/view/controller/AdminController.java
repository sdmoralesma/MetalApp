package com.smorales.headbanging.view.controller;

import com.smorales.headbanging.boundary.AdminDAO;
import com.smorales.headbanging.entity.*;
import com.smorales.headbanging.view.model.AdminModel;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AdminController {

    @Inject
    AdminModel adminModel;

    @Inject
    AdminDAO adminDAO;

    public String registerArtist() {
        return adminDAO.registerArtist(adminModel.getArtist());
    }

    public List<Artist> artistList() {
        return adminDAO.artistList();
    }

    public String registerGender() {
        return adminDAO.registerGender(adminModel.getGender());
    }

    public List<Gender> genderList() {
        return adminDAO.genderList();
    }

    public String registerSong() {
        return adminDAO.registerSong(adminModel.getSong(), adminModel.getSelectedArtistName(), adminModel.getSelectedGenderName());
    }

    public List<Song> songList() {
        return adminDAO.songList();
    }

    public String registerJury() {
        return adminDAO.registerJury(adminModel.getJury());
    }

    public List<Jury> juryList() {
        return adminDAO.juryList();
    }

    public String registerParticipant() {
        return adminDAO.registerParticipant(adminModel.getParticipant());
    }

    public List<Participant> participantList() {
        return adminDAO.participantList();
    }

}
