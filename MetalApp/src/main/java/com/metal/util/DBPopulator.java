package com.metal.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ejb.Startup;

import com.metal.model.Admin;
import com.metal.model.Artist;
import com.metal.model.Gender;
import com.metal.model.Jury;
import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.service.AdminBean;
import com.metal.service.JuryBean;
import com.metal.service.ParticipantBean;

@Singleton
@Startup
public class DBPopulator {

	@Inject
	private AdminBean adminBean;
	@Inject
	private JuryBean juryBean;
	@Inject
	private ParticipantBean participantBean;

	private Admin admin1;
	private Admin admin2;
	private Participant participant1;
	private Participant participant2;
	private Jury jury1;
	private Jury jury2;
	private Gender gender1;
	private Gender gender2;
	private Artist artist1;
	private Artist artist2;
	private Song song1;
	private Song song2;

	@PostConstruct
	private void populateDb() {
		initAdmins();
		initJuries();
		initParticipants();
		initArtists();
		initGenders();
		initSongs();
	}

	@PreDestroy
	private void cleanDb() {
		adminBean.deleteInstance(admin1);
		adminBean.deleteInstance(admin2);
		adminBean.deleteInstance(jury1);
		adminBean.deleteInstance(jury2);
		adminBean.deleteInstance(participant1);
		adminBean.deleteInstance(participant2);
		adminBean.deleteInstance(song1);
		adminBean.deleteInstance(song2);
		adminBean.deleteInstance(gender1);
		adminBean.deleteInstance(gender2);
		adminBean.deleteInstance(artist1);
		adminBean.deleteInstance(artist2);
	}

	private void initAdmins() {
		admin1 = new Admin("admin1", "admin", "admin", "Incredible Admin1", "Administrator1");
		adminBean.setAdmin(admin1);
		adminBean.registerAdmin();
		admin2 = new Admin("admin2", "admin", "admin", "Incredible Admin2", "Administrator2");
		adminBean.setAdmin(admin2);
		adminBean.registerAdmin();
	}

	private void initParticipants() {
		participant1 = new Participant("pepe1", "participant", "pepe", 35, "Colombia", "Male", "Peperoni1", "headBee.gif");		
		adminBean.setParticipant(participant1);
		adminBean.registerParticipant();
		participant2 = new Participant("pepe2", "participant", "pepe", 42, "Chile", "Female", "Peperoni2", "mario.gif");
		adminBean.setParticipant(participant2);
		adminBean.registerParticipant();
	}

	private void initJuries() {
		jury1 = new Jury("jury1", "jury", "jury", "The Jury1", "jury1");
		adminBean.setJury(jury1);
		adminBean.registerJury();
		jury2 = new Jury("jury2", "jury", "jury", "The Jury2", "jury2");
		adminBean.setJury(jury2);
		adminBean.registerJury();
	}

	private void initGenders() {
		gender1 = new Gender("Death Metal", 5, 5);
		adminBean.setGender(gender1);
		adminBean.registerGender();
		gender2 = new Gender("Progressive Metal", 7, 4);
		adminBean.setGender(gender2);
		adminBean.registerGender();
	}

	private void initArtists() {
		artist1 = new Artist("Arch Enemy", "Swedish Band");
		adminBean.setArtist(artist1);
		adminBean.registerArtist();
		artist2 = new Artist("Symphony X", "North American Band");
		adminBean.setArtist(artist2);
		adminBean.registerArtist();
	}

	private void initSongs() {
		song1 = new Song("Nemesis", artist1, gender1);
		adminBean.setSong(song1);
		adminBean.setSelectedArtistName("Arch Enemy");
		adminBean.setSelectedGenderName("Death Metal");
		adminBean.registerSong();

		song2 = new Song("Masquerade", artist2, gender2);
		adminBean.setSong(song2);
		adminBean.setSelectedArtistName("Symphony X");
		adminBean.setSelectedGenderName("Progressive Metal");
		adminBean.registerSong();
	}

}
