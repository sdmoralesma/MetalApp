package com.smorales.headbanging.presentation.controller;

import com.smorales.headbanging.boundary.AdminService;
import com.smorales.headbanging.entity.*;
import com.smorales.headbanging.presentation.model.AdminModel;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AdminController {

    @Inject
    AdminModel adminModel;

    @Inject
    AdminService adminService;

    @Inject
    FacesContext facesContext;

    public String registerJury() {
        adminService.registerJury(adminModel.getJury());
        return "registerJury.xhtml?faces-redirect=true";
    }

    public List<Jury> juryList() {
        return adminService.juryList();
    }

    public String registerParticipant() {
        adminService.registerParticipant(adminModel.getParticipant());
        return "registerParticipant.xhtml?faces-redirect=true";
    }

    public List<Participant> participantList() {
        return adminService.participantList();
    }

    public String registerAdmin() {
        adminService.registerAdmin(adminModel.getAdmin());
        return "registerAdmin.xhtml?faces-redirect=true";
    }

    public List<Admin> adminList() {
        return adminService.adminList();
    }
}
