package com.metal.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.metal.model.Jury;
import com.metal.model.Participant;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class Facade {

	@EJB
	private ServiceAdmin serviceAdmin;
	@EJB
	private ServiceJury serviceJury;
	@EJB
	private ServiceScore serviceScore;

	public Facade() {
	}

	public void registerParticipant(Participant participant) {
		serviceAdmin.createParticipant(participant);
	}

	public void registerJury(Jury jury) {
		serviceAdmin.createJury(jury);
	}

	public List<Participant> findParticipants() {
		return serviceAdmin.findAllParticipants();
	}

	public List<Jury> findJuries() {
		return serviceAdmin.findAllJuries();
	}

}
