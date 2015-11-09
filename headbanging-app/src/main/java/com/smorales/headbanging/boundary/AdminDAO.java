package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.*;

import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public <T> T findInstanceById(Class<T> clazz, Object id) {
        return em.find(clazz, id);
    }

    public String registerAdmin(Admin admin) {
        admin.setGroup("admin");
        em.persist(admin);
        return "registerAdmin.xhtml?faces-redirect=true";
    }

    public String registerJury(Jury jury) {
        jury.setGroup("jury");
        em.persist(jury);
        return "registerJury.xhtml?faces-redirect=true";
    }

    public String registerParticipant(Participant participant) {
        participant.setGroup("participant");
        if (participant.getImage_url() == null || participant.getImage_url().compareToIgnoreCase("") == 0) {
            participant.setImage_url("default.jpg");
        }
        ScoreMatrix score = new ScoreMatrix();
        score.setParticipant(participant);
        participant.setScoreMatrix(score);
        em.persist(participant);
        return "registerParticipant.xhtml?faces-redirect=true";
    }

    public String registerSong(Song song, String selectedArtistName, String selectedGenderName) {
        Artist selectedArtist = em.find(Artist.class, selectedArtistName);
        Gender selectedGender = em.find(Gender.class, selectedGenderName);
        if (selectedArtist == null || selectedGender == null) {
            throw new RuntimeErrorException(null, "Alguna referencia es Null: " + "\nArtist: " + selectedArtist
                    + "\nGender: " + selectedGender);
        }
        song = new Song(song.getTitle(), selectedArtist, selectedGender);
        em.persist(song);
        return "registerSong?faces-redirect=true";
    }

    public String registerArtist(Artist artist) {
        em.persist(artist);
        return "registerArtist.xhtml?faces-redirect=true";
    }

    public String registerGender(Gender gender) {
        em.persist(gender);
        return "registerGender.xhtml?faces-redirect=true";
    }

}