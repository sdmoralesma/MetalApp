package com.smorales.headbanging.presentation.controller;

import com.smorales.headbanging.boundary.JuryService;
import com.smorales.headbanging.presentation.model.JuryModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class JuryController {

    @Inject
    JuryService juryService;

    @Inject
    JuryModel juryModel;

    @Inject
    FacesContext facesContext;

    public String votePerParticipant() {
        juryService.votePerParticipant(juryModel.getParticipant(), juryModel.getHandPoints(), juryModel.getHeadPoints());

        FacesMessage msg = new FacesMessage("The Vote has been Registered!");
        facesContext.addMessage(null, msg);
        return "votePerParticipant.xhtml";
    }

}
