package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.*;

import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AdministratorDAO {

    @PersistenceContext
    EntityManager em;

    public List<Song> songList() {
        TypedQuery<Song> typedQuery = em.createNamedQuery(Song.FIND_ALL, Song.class);
        return typedQuery.getResultList();
    }

    public List<ParticipantDAO> participantList() {
        TypedQuery<ParticipantDAO> typedQuery = em.createNamedQuery(Participant.FIND_ALL, ParticipantDAO.class);
        return typedQuery.getResultList();
    }

    public List<Gender> genderList() {
        TypedQuery<Gender> typedQuery = em.createNamedQuery(Gender.FIND_ALL, Gender.class);
        return typedQuery.getResultList();
    }

    public List<Artist> artistList() {
        TypedQuery<Artist> typedQuery = em.createNamedQuery(Artist.FIND_ALL, Artist.class);
        return typedQuery.getResultList();
    }

    public List<JuryDAO> juryList() {
        TypedQuery<JuryDAO> typedQuery = em.createNamedQuery(Jury.FIND_ALL, JuryDAO.class);
        return typedQuery.getResultList();
    }

    public List<Admin> adminList() {
        TypedQuery<Admin> typedQuery = em.createNamedQuery(Admin.FIND_ALL, Admin.class);
        return typedQuery.getResultList();
    }

    public <T> T findInstanceById(Class<T> clazz, Object id) {
        return em.find(clazz, id);
    }

    public <T> T updateInstance(T instance) {
        return em.merge(instance);
    }

    public <T> void deleteInstance(T instance) {
        em.remove(em.merge(instance));
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
