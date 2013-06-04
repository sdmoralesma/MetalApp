package com.metal.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Admin;
import com.metal.model.Artist;
import com.metal.model.Gender;
import com.metal.model.Jury;
import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;
import com.metal.model.Song;

/**
 * Registra Usuarios y Administradores en el sistema
 */
@Named
@Stateless
public class AdminBean {

    @PersistenceContext
    private EntityManager em;
    @Inject
    private Admin admin;
    @Inject
    private Jury jury;
    @Inject
    private Participant participant;
    @Inject
    private Song song;
    @Inject
    private Gender gender;
    @Inject
    private Artist artist;
    private String selectedArtistName;
    private String selectedGenderName;

    public AdminBean() {
    }

    public List<Song> songList() {
        return this.findAllInstances(Song.FIND_ALL, Song.class);
    }

    public List<Participant> participantList() {
        return this.findAllInstances(Participant.FIND_ALL, Participant.class);
    }

    public List<Gender> genderList() {
        return this.findAllInstances(Gender.FIND_ALL, Gender.class);
    }

    public List<Artist> artistList() {
        return this.findAllInstances(Artist.FIND_ALL, Artist.class);
    }

    public List<Jury> juryList() {
        return this.findAllInstances(Jury.FIND_ALL, Jury.class);
    }

    public List<Admin> adminList() {
        return this.findAllInstances(Admin.FIND_ALL, Admin.class);
    }

    public <T> List<T> findAllInstances(String query, Class<T> clazz) {
        TypedQuery<T> typedQuery = em.createNamedQuery(query, clazz);
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

    public String registerAdmin() {
        this.admin.setGroup("admin");
        em.persist(this.admin);
        return "registerAdmin.xhtml";
    }

    public String registerJury() {
        this.jury.setGroup("jury");
        em.persist(this.jury);
        return "registerJury.xhtml";
    }

    public String registerParticipant() {
        participant.setGroup("participant");
        if (participant.getImage_url() == null || participant.getImage_url().compareToIgnoreCase("") == 0) {
            participant.setImage_url("default.jpg");
        }
        ScoreMatrix score = new ScoreMatrix();
        score.setParticipant(participant);
        participant.setScoreMatrix(score);
        em.persist(participant);
        return "registerParticipant.xhtml";
    }

    public String registerSong() {
        Artist selectedArtist = em.find(Artist.class, selectedArtistName);
        Gender selectedGender = em.find(Gender.class, selectedGenderName);
        if (selectedArtist == null || selectedGender == null) {
            throw new RuntimeErrorException(null, "Alguna referencia es Null: " + "\nArtist: " + selectedArtist
                    + "\nGender: " + selectedGender);
        }
        this.song = new Song(this.song.getTitle(), selectedArtist, selectedGender);
        em.persist(this.song);
        return "registerSong";
    }

    public String registerArtist() {
        em.persist(this.artist);
        return "registerArtist.xhtml";
    }

    public String registerGender() {
        em.persist(this.gender);
        return "registerGender.xhtml";
    }

    // Getters & Setters
    // --------------------------------------------------------------
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getSelectedGenderName() {
        return selectedGenderName;
    }

    public void setSelectedGenderName(String selectedGenderName) {
        this.selectedGenderName = selectedGenderName;
    }

    public String getSelectedArtistName() {
        return selectedArtistName;
    }

    public void setSelectedArtistName(String selectedArtistName) {
        this.selectedArtistName = selectedArtistName;
    }
}
