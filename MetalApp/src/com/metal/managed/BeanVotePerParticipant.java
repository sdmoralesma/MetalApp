package com.metal.managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.metal.ejb.FacadeEJB;
import com.metal.model.Participant;

@ManagedBean
@RequestScoped
public class BeanVotePerParticipant {

	@EJB
	private FacadeEJB facade;

	private Participant participant = new Participant();
	private List<Participant> participantList = new ArrayList<>();

	public String doVotePerParticipant() {
		facade.registerVotePerParticipant(participant);
		participantList = facade.findParticipants();
		return "votePerParticipant.xhtml";
	}

	// Getters y Setters
	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}
}
