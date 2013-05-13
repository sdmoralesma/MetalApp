package com.metal.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.service.AdminBean;
import com.metal.service.VoteBean;

@WebService
public class Statistics implements StatisticsWs {

	@EJB
	AdminBean adminEJB;
	
	@EJB
	VoteBean scoreEJB;

	@Override
	public List<Participant> getRatingParticipants() {
		return adminEJB.findAllInstances("Participant.findAll", Participant.class);
	}

	@Override
	public List<Song> getRatingSongs() {
		return scoreEJB.findAllSongs();
	}

	@Override
	public Participant getRatingPerParticipant(@WebParam Participant participant) {
		System.out.println("WS RatingPerParticipant");
		return null;
	}

	@Override
	public String getCadena() {
		return "TEST";
	}
}
