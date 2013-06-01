package com.metal.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.model.Participant;
import com.metal.model.Song;

@WebService
@Stateless
public interface StatisticsWs {

	public List<Participant> getRatingParticipants();

	public List<Song> getRatingSongs();

	public Participant getRatingPerParticipant(@WebParam Participant participant);

	public String getStringTest();
}
