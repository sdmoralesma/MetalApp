package com.metal.webservice;

import com.metal.model.Participant;
import com.metal.model.Song;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface StatisticsWs {

    public List<Participant> getRatingParticipants();

    public List<Song> getRatingSongs();

    public Participant getRatingPerParticipant(@WebParam Participant participant);

    public String getStringTest();
}
