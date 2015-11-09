package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;

@Named
@Stateless
public class ParticipantDAO {

    @PersistenceContext
    EntityManager em;

    @PostConstruct//TODO: what is this doing here!
    public void populateParticipant(Participant participant) {
        participant = this.findParticipantByPK();
    }

    public Participant findParticipantByPK() {
        String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return em.createNamedQuery(Participant.FIND_BY_USERNAME, Participant.class)
                .setParameter("username", nameLoggedUser)
                .getSingleResult();
    }

    public void updateParticipant(Participant participant) {
        em.merge(participant);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Updated Participant"));
    }

    public void deleteParticipant(Participant participant) {
        em.remove(em.merge(participant));
    }

    public void handleFileUpload(FileUploadEvent event, Participant participant) {

        try {
            String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

            final String PATH_TO_SAVE_IMAGES = "/home/sergio/uploaded/images"; //Unix

            File targetFolder = new File(PATH_TO_SAVE_IMAGES);
            UploadedFile inImage = event.getFile();
            InputStream inputStream = inImage.getInputstream();

            String newFileName = getFileName(inImage.getFileName(), nameLoggedUser);
            File newImage = new File(targetFolder, newFileName);
            OutputStream outStream = new FileOutputStream(newImage);

            File currentImage = new File(targetFolder.getPath() + "/" + participant.getImage_url());

            // Si la nueva imagen tiene una extension distinta a la actual,
            // entonces, borra la imagen actual
            if (!currentImage.getName().equalsIgnoreCase(newImage.getName())) {
                boolean delete = currentImage.delete();
                System.out.println("deleted: " + currentImage.toString());
            }

            byte[] bytes = new byte[1024];

            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                outStream.write(bytes, 0, read);
            }
            inputStream.close();
            outStream.flush();
            outStream.close();

            participant.setImage_url(newFileName);
            updateParticipant(participant);

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
