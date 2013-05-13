package com.metal.data;

import java.util.ArrayList;

import javax.resource.NotSupportedException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metal.model.Participant;
import com.metal.model.Presentation;
import com.metal.model.ScoreMatrix;
import com.metal.service.AdminBean;

public class DummyData {

	private AdminBean bean;

	@Before
	public void setUp() throws Exception {
		bean = new AdminBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test()
	public void shouldCreateAdmins() throws NotSupportedException {
		Participant participant = new Participant(31, "myhouse", "FEMALE", "asdf", "asdf",
				new ArrayList<Presentation>(), new ScoreMatrix());
		bean.setParticipant(participant);
		bean.registerParticipant();

	}
}
