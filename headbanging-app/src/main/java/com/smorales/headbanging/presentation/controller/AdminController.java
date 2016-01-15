package com.smorales.headbanging.presentation.controller;

import com.smorales.headbanging.business.boundary.AdminService;
import com.smorales.headbanging.business.entity.Admin;
import com.smorales.headbanging.business.entity.Jury;
import com.smorales.headbanging.business.entity.Participant;
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

    public String registerAdmin() {
        adminService.registerAdmin(adminModel.getAdmin());
        return "registerAdmin.xhtml?faces-redirect=true";
    }

    public String registerJury() {
        adminService.registerJury(adminModel.getJury());
        return "registerJury.xhtml?faces-redirect=true";
    }


    public String registerParticipant() {
        adminService.registerParticipant(adminModel.getParticipant());
        return "registerParticipant.xhtml?faces-redirect=true";
    }

    public List<Jury> juryList() {
        return adminService.juryList();
    }

    public List<Participant> participantList() {
        return adminService.participantList();
    }

    public List<Admin> adminList() {
        return adminService.adminList();
    }
}
