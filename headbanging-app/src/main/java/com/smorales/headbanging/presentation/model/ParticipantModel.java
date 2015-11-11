package com.smorales.headbanging.presentation.model;

import com.smorales.headbanging.entity.Participant;

import javax.inject.Named;

@Named
public class ParticipantModel {

    private Participant participant;

    // Getters / Setters
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
