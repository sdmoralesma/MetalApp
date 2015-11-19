package com.smorales.headbanging.presentation.model;

import com.smorales.headbanging.entity.Participant;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class JuryModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Participant participant;
    private Integer points;

    @PostConstruct
    public void init() {
        points = 1;
        participant = new Participant();
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
