package com.metal.test;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.metal.model.Admin;
import com.metal.model.Artist;
import com.metal.model.Gender;
import com.metal.model.Jury;
import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.model.SongMatrix;
import com.metal.service.AdminBean;
import com.metal.service.JuryBean;
import com.metal.webservice.Statistics;
import com.metal.webservice.StatisticsWs;

@RunWith(Arquillian.class)
public class StatisticsIT {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addClasses(StatisticsWs.class, Statistics.class)
				.addClasses(AdminBean.class, Admin.class, Jury.class, Participant.class, Song.class, Gender.class,
						Artist.class).addClasses(JuryBean.class, SongMatrix.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	Statistics statistics;

	@EJB
	AdminBean bean;

	@Test
	public void shouldGetRatingParticipants() {
		Assert.assertEquals("hey", statistics.getRatingParticipants());
	}


	// @Test
	// public void sholdGetRatingSongs() {
	// Assert.assertEquals("hey", statistics.getRatingSongs());
	// }
	//
	// @Test
	// public void sholdGetRatingPerParticipant() {
	// Participant p = new Participant("pepe1", null, null, 0, null, null, null,
	// null);
	// Assert.assertEquals("pepe1", statistics.getRatingPerParticipant(p));
	// }


	@Test
	public void shouldGetStringTest() {
		Assert.assertEquals("This is a Test", statistics.getStringTest());
	}
}
