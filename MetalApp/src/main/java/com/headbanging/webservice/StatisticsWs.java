package com.headbanging.webservice;

import com.headbanging.entity.Participant;
import com.headbanging.entity.Song;

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
