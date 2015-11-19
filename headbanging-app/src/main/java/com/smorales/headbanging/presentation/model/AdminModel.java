package com.smorales.headbanging.presentation.model;

import com.smorales.headbanging.entity.Admin;
import com.smorales.headbanging.entity.Jury;
import com.smorales.headbanging.entity.Participant;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AdminModel implements Serializable{

    private static final long serialVersionUID = 1L;

    private Admin admin;
    private Jury jury;
    private Participant participant;

    @PostConstruct
    public void init() {
        admin = new Admin();
        jury = new Jury();
        participant = new Participant();
    }

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

}
