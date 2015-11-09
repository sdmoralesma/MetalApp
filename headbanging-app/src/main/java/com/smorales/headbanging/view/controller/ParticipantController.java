package com.smorales.headbanging.view.controller;

import com.smorales.headbanging.boundary.ParticipantDAO;
import com.smorales.headbanging.view.model.ParticipantModel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ParticipantController {

    @Inject
    ParticipantDAO participantDAO;

    @Inject
    ParticipantModel participantModel;

    @PostConstruct
    public void populateParticipant() {
        participantModel.setParticipant(participantDAO.findParticipantByPK());
    }
}
