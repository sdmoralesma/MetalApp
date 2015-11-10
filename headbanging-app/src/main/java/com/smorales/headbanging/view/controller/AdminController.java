package com.smorales.headbanging.view.controller;

import com.smorales.headbanging.boundary.AdminDAO;
import com.smorales.headbanging.entity.*;
import com.smorales.headbanging.view.model.AdminModel;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AdminController {

    @Inject
    AdminModel adminModel;

    @Inject
    AdminDAO adminDAO;

    @Inject
    FacesContext facesContext;

    public String registerArtist() {
        adminDAO.registerArtist(adminModel.getArtist());
        return "registerArtist.xhtml?faces-redirect=true";
    }

    public List<Artist> artistList() {
        return adminDAO.artistList();
    }

    public String registerGender() {
        adminDAO.registerGender(adminModel.getGender());
        return "registerGender.xhtml?faces-redirect=true";
    }

    public List<Gender> genderList() {
        return adminDAO.genderList();
    }

    public String registerSong() {
        adminDAO.registerSong(adminModel.getSong(), adminModel.getSelectedArtistName(), adminModel.getSelectedGenderName());
        return "registerSong?faces-redirect=true";
    }

    public List<Song> songList() {
        return adminDAO.songList();
    }

    public String registerJury() {
        adminDAO.registerJury(adminModel.getJury());
        return "registerJury.xhtml?faces-redirect=true";
    }

    public List<Jury> juryList() {
        return adminDAO.juryList();
    }

    public String registerParticipant() {
        adminDAO.registerParticipant(adminModel.getParticipant());
        return "registerParticipant.xhtml?faces-redirect=true";
    }

    public List<Participant> participantList() {
        return adminDAO.participantList();
    }

    public String registerAdmin() {
        adminDAO.registerAdmin(adminModel.getAdmin());
        return "registerAdmin.xhtml?faces-redirect=true";
    }

    public List<Admin> adminList() {
        return adminDAO.adminList();
    }
}
