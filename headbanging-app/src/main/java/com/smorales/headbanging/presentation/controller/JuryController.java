package com.smorales.headbanging.presentation.controller;

import com.smorales.headbanging.boundary.AdminService;
import com.smorales.headbanging.boundary.JuryService;
import com.smorales.headbanging.entity.User;
import com.smorales.headbanging.presentation.model.JuryModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class JuryController {

    @Inject
    JuryService juryService;

    @Inject
    AdminService adminService;

    @Inject
    JuryModel juryModel;

    @Inject
    FacesContext facesContext;

    public String votePerParticipant() {
        juryService.votePerParticipant(juryModel.getParticipant(), juryModel.getPoints());

        FacesMessage msg = new FacesMessage("The Vote has been Registered!");
        facesContext.addMessage(null, msg);
        return "votePerParticipant.xhtml";
    }

    public List<String> autocompleteParticipants(String query) {
        return adminService.participantsUsernameLike(query).stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

}
