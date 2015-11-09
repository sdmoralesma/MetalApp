package com.smorales.headbanging.view.model;

import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.Song;
import com.smorales.headbanging.entity.SongMatrix;

import javax.inject.Named;

@Named
public class JuryModel {

    private Integer musicalityPoints;
    private Integer compositionPoints;
    private Integer handPoints;
    private Integer headPoints;

    private Participant participant;
    private Song song;
    private SongMatrix matrix;


    // Getters / Setters
    public Integer getMusicalityPoints() {
        return musicalityPoints;
    }

    public void setMusicalityPoints(Integer musicalityPoints) {
        this.musicalityPoints = musicalityPoints;
    }

    public Integer getCompositionPoints() {
        return compositionPoints;
    }

    public void setCompositionPoints(Integer compositionPoints) {
        this.compositionPoints = compositionPoints;
    }

    public Integer getHandPoints() {
        return handPoints;
    }

    public void setHandPoints(Integer handPoints) {
        this.handPoints = handPoints;
    }

    public Integer getHeadPoints() {
        return headPoints;
    }

    public void setHeadPoints(Integer headPoints) {
        this.headPoints = headPoints;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public SongMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(SongMatrix matrix) {
        this.matrix = matrix;
    }
}
