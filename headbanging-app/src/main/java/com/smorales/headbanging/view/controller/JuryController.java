package com.smorales.headbanging.view.controller;

import com.smorales.headbanging.boundary.JuryDAO;
import com.smorales.headbanging.view.model.JuryModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class JuryController {

    @Inject
    JuryDAO juryDAO;

    @Inject
    JuryModel juryModel;

    @Inject
    FacesContext facesContext;

    public String votePerParticipant() {
        juryDAO.votePerParticipant(juryModel.getParticipant(), juryModel.getHandPoints(), juryModel.getHeadPoints());

        FacesMessage msg = new FacesMessage("The Vote has been Registered!");
        facesContext.addMessage(null, msg);
        return "votePerParticipant.xhtml";
    }

    public String votePerSong() {
        juryDAO.votePerSong(juryModel.getSong(), juryModel.getCompositionPoints(), juryModel.getMusicalityPoints());

        FacesMessage msg = new FacesMessage("The Vote has been Registered!");
        facesContext.addMessage(null, msg);
        return "votePerSong.xhtml";
    }

}
