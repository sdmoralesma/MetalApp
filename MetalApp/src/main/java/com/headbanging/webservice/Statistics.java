package com.headbanging.webservice;

import com.headbanging.boundary.AdminBean;
import com.headbanging.boundary.JuryBean;
import com.headbanging.entity.Participant;
import com.headbanging.entity.Song;

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
