package com.metal.webservice;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.model.Participant;
import com.metal.model.Song;

/**
 * Session Bean implementation class WebServiceFacade
 */
@WebService
@Stateless
@LocalBean
public class FacadeWebService {

	public List<Participant> getRatingParticipants() {
		return null;
	}

	public List<Song> getRatingSongs() {
		return null;
	}

	public Participant getRatingPerParticipant(@WebParam Participant participant) {
		return null;
	}
}
