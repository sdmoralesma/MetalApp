package com.metal.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.ejb.ServiceAdminEJB;
import com.metal.ejb.ServiceScoreEJB;
import com.metal.model.Participant;
import com.metal.model.Song;

@WebService
public class Statistics implements StatisticsWs {

	@EJB
	ServiceAdminEJB adminEJB;
	
	@EJB
	ServiceScoreEJB scoreEJB;

	@Override
	public List<Participant> getRatingParticipants() {
		return adminEJB.findAllParticipants();
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
