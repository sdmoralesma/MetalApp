package com.smorales.headbanging.view.controller;

import com.smorales.headbanging.boundary.JuryDAO;
import com.smorales.headbanging.view.model.JuryModel;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class JuryController {

    @Inject
    JuryDAO juryDAO;

    @Inject
    JuryModel juryModel;

    public String votePerParticipant() {
        return juryDAO.votePerParticipant(juryModel.getParticipant(), juryModel.getHandPoints(), juryModel.getHeadPoints());
    }

    public String votePerSong() {
        return juryDAO.votePerSong(juryModel.getSong(), juryModel.getCompositionPoints(), juryModel.getMusicalityPoints());
    }


}
