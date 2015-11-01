package com.smorales.headbanging.webservice;

import com.smorales.headbanging.boundary.AdminBean;
import com.smorales.headbanging.boundary.JuryBean;
import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.Song;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.headbanging.webservice.Statistics")
public class Statistics implements StatisticsWs {

    @Inject
    AdminBean adminBean;
    @Inject
    JuryBean juryBean;

    @Override
    public List<Participant> getRatingParticipants() {
        return adminBean.findAllInstances(Participant.FIND_ALL, Participant.class);
    }

    @Override
    public List<Song> getRatingSongs() {
        return juryBean.findAllInstances(Song.FIND_ALL, Song.class);
    }

    @Override
    public Participant getRatingPerParticipant(@WebParam Participant participant) {
        return adminBean.findInstanceById(Participant.class, participant.getUsername());
    }

    @Override
    public String getStringTest() {
        return "This is a Test";
    }
}
