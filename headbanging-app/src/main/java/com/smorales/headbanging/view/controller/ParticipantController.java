package com.smorales.headbanging.view.controller;

import com.smorales.headbanging.boundary.ParticipantDAO;
import com.smorales.headbanging.view.model.ParticipantModel;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;

@Named
public class ParticipantController {

    @Inject
    ParticipantDAO participantDAO;

    @Inject
    ParticipantModel participantModel;

    @PostConstruct
    public void populateParticipant() {
        participantModel.setParticipant(participantDAO.findParticipantByPK());
    }

    public void updateParticipant() {
        participantDAO.updateParticipant(participantModel.getParticipant());
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            String nameLoggedUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

            final String PATH_TO_SAVE_IMAGES = "/home/sergio/uploaded/images"; //Unix

            File targetFolder = new File(PATH_TO_SAVE_IMAGES);
            UploadedFile inImage = event.getFile();
            InputStream inputStream = inImage.getInputstream();

            String newFileName = getFileName(inImage.getFileName(), nameLoggedUser);
            File newImage = new File(targetFolder, newFileName);
            OutputStream outStream = new FileOutputStream(newImage);

            File currentImage = new File(targetFolder.getPath() + "/" + participantModel.getParticipant().getImage_url());

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

            participantModel.getParticipant().setImage_url(newFileName);
            updateParticipant();

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
