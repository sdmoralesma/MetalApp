package com.metal.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.service.AdminBean;
import com.metal.service.JuryBean;
import com.metal.service.ParticipantBean;

@Stateless
@Local(StatisticsWs.class)
@Remote(StatisticsWs.class)
@WebService
public class Statistics implements StatisticsWs {

//	@EJB
	AdminBean adminBean = new AdminBean();

//	@EJB
	JuryBean juryBean;

	@Override
	public List<Participant> getRatingParticipants() {
		System.out.println("------->>  Call Started");
		return adminBean.findAllInstances(Participant.FIND_ALL, Participant.class);
	}

	@Override
	public List<Song> getRatingSongs() {
		System.out.println("------->>  Call Started");
		return juryBean.findAllInstances(Song.FIND_ALL, Song.class);
	}

	@Override
	public Participant getRatingPerParticipant(@WebParam Participant participant) {
		System.out.println("------->>  Call Started");
		return adminBean.findInstanceById(Participant.class, participant.getUsername());
	}

	@Override
	public String getCadena() {
		return "TEST";
	}
}
