package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Stateless
public class AdminDAO {

    @PersistenceContext
    EntityManager em;

    public List<Song> songList() {
        return em.createNamedQuery(Song.FIND_ALL, Song.class).getResultList();
    }

    public List<Participant> participantList() {
        return em.createNamedQuery(Participant.FIND_ALL, Participant.class).getResultList();
    }

    public List<Gender> genderList() {
        return em.createNamedQuery(Gender.FIND_ALL, Gender.class).getResultList();
    }

    public List<Artist> artistList() {
        return em.createNamedQuery(Artist.FIND_ALL, Artist.class).getResultList();
    }

    public List<Jury> juryList() {
        return em.createNamedQuery(Jury.FIND_ALL, Jury.class).getResultList();
    }

    public List<Admin> adminList() {
        return em.createNamedQuery(Admin.FIND_ALL, Admin.class).getResultList();
    }

    public Participant findParticipantByUsername(Object id) {
        return em.find(Participant.class, id);
    }

    public void registerAdmin(Admin admin) {
        admin.setGroup("admin");
        em.persist(admin);
    }

    public void registerJury(Jury jury) {
        jury.setGroup("jury");
        em.persist(jury);
    }

    public void registerParticipant(Participant participant) {
        participant.setGroup("participant");
        if (participant.getImage_url() == null || participant.getImage_url().equals("")) {
            participant.setImage_url("default.jpg");
        }
        ScoreMatrix score = new ScoreMatrix();
        score.setParticipant(participant);
        participant.setScoreMatrix(score);
        em.persist(participant);
    }

    public void registerSong(Song song, String selectedArtistName, String selectedGenderName) {
        Artist selectedArtist = em.find(Artist.class, selectedArtistName);
        Gender selectedGender = em.find(Gender.class, selectedGenderName);

        Objects.requireNonNull(selectedArtist);
        Objects.requireNonNull(selectedGender);

        song = new Song(song.getTitle(), selectedArtist, selectedGender);
        em.persist(song);
    }

    public void registerArtist(Artist artist) {
        em.persist(artist);
    }

    public void registerGender(Gender gender) {
        em.persist(gender);
    }

}