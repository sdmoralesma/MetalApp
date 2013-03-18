package com.metal.managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.metal.ejb.Facade;
import com.metal.model.Participant;

@ManagedBean
@RequestScoped
public class registerParticipant {

	@EJB
	private Facade facade;
	
	private Participant participant = new Participant();
	private List<Participant> participantList = new ArrayList<>();
	
	public String doCreateParticipant(){
		facade.registerParticipant(participant);
		participantList = facade.findParticipants();
		return "registerParticipant";
	}
	
	
	
}
