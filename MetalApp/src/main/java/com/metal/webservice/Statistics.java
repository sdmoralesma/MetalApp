package com.metal.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.service.AdminBean;
import com.metal.service.JuryBean;

@Stateless
// @WebService
//@LocalBean
public class Statistics implements StatisticsWs {

	// @EJB
	@Inject
	AdminBean adminBean;

	// @EJB
//	@Inject
//	JuryBean juryBean;

	@Override
	public List<Participant> getRatingParticipants() {
		System.out.println("------->>  Call Started");
		return adminBean.findAllInstances(Participant.FIND_ALL, Participant.class);
	}

	// @Override
	// public List<Song> getRatingSongs() {
	// System.out.println("------->>  Call Started");
	// return juryBean.findAllInstances(Song.FIND_ALL, Song.class);
	// }

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
