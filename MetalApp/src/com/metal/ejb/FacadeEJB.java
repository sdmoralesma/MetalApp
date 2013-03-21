package com.metal.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.metal.model.Jury;
import com.metal.model.Participant;
import com.metal.model.Song;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class FacadeEJB {

	@EJB
	private ServiceAdminEJB serviceAdmin;
	@EJB
	private ServiceJuryEJB serviceJury;
	@EJB
	private ServiceScoreEJB serviceScore;

	public FacadeEJB() {
	}

	// SERVICE ADMIN
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

	// SERVICE JURY
	public void registerVotePerParticipant(Participant participant) {
		serviceJury.addVotePerParticipant(participant);
	}
	
	public void registerVotePerSong(Song song) {
		serviceJury.addVotePerSong(song);
	}
	
}
