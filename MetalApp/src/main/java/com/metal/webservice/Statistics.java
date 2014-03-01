package com.metal.webservice;

import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.service.AdminBean;
import com.metal.service.JuryBean;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.metal.webservice.Statistics")
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
