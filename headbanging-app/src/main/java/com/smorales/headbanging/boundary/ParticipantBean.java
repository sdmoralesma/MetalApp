package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.*;

/**
 * Permite a un participante ver su propio perfil y modificarlo
 */
@Named
@Transactional
@RequestScoped
public class ParticipantBean {

    @PersistenceContext
    private EntityManager em;
    @Inject
    private Participant participant;

    public ParticipantBean() {
    }

    @PostConstruct
    public void populateParticipant() {
        this.participant = this.findParticipantByPK();
    }

    public Participant findParticipantByPK() {
        String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        TypedQuery<Participant> query = em.createNamedQuery(Participant.FIND_BY_USERNAME, Participant.class);
        query.setParameter("username", nameLoggedUser);
        return query.getSingleResult();
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public void updateParticipant() {
        em.merge(this.participant);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Updated Participant"));
    }

    public void deleteParticipant() {
        em.remove(em.merge(this.participant));
    }

    public void handleFileUpload(FileUploadEvent event) {

        try {
            String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

            final String PATH_TO_SAVE_IMAGES = "/home/sergio/uploaded/images"; //Unix
//            final String PATH_TO_SAVE_IMAGES = "C:/Users/sergio/Documents/images/"; // Win7

            File targetFolder = new File(PATH_TO_SAVE_IMAGES);
            UploadedFile inImage = event.getFile();
            InputStream inputStream = inImage.getInputstream();

            String newFileName = getFileName(inImage.getFileName(), nameLoggedUser);
            File newImage = new File(targetFolder, newFileName);
            OutputStream outStream = new FileOutputStream(newImage);

            File currentImage = new File(targetFolder.getPath() + "/" + participant.getImage_url());

            // Si la nueva imagen tiene una extension distinta a la actual,
            // entonces, borra la imagen actual
            if (currentImage.getName().equalsIgnoreCase(newImage.getName()) == false) {
                currentImage.delete();
            }

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outStream.write(bytes, 0, read);
            }
            inputStream.close();
            outStream.flush();
            outStream.close();

            this.participant.setImage_url(newFileName);
            this.updateParticipant();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesful", inImage.getFileName()
                    + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(String fileName, String userName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return userName + "." + extension;
    }
}
