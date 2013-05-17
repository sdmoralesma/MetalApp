package com.metal.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.service.AdminBean;
import com.metal.service.JuryBean;
import com.metal.service.ParticipantBean;

@WebService
public class Statistics implements StatisticsWs {

	@EJB
	AdminBean adminBean;

	@EJB
	ParticipantBean participantBean;

	@EJB
	JuryBean juryBean;

	@Override
	public List<Participant> getRatingParticipants() {
		return adminBean.findAllInstances("Participant.findAll", Participant.class);
	}

	@Override
	public List<Song> getRatingSongs() {
		return juryBean.findAllInstances("Song.findAll", Song.class);
	}

	@Override
	public Participant getRatingPerParticipant(@WebParam Participant participant) {
		return participantBean.findParticipantByPK();
	}

	@Override
	public String getCadena() {
		return "TEST";
	}
}
