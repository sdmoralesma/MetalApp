package com.smorales.headbanging.presentation.controller;

import com.smorales.headbanging.boundary.ParticipantService;
import com.smorales.headbanging.presentation.model.ParticipantModel;
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
    ParticipantService participantService;

    @Inject
    ParticipantModel participantModel;

    @Inject
    FacesContext facesContext;

    @PostConstruct
    public void populateParticipant() {
        String nameLoggedUser = facesContext.getExternalContext().getRemoteUser();
        participantModel.setParticipant(participantService.findParticipantByPK(nameLoggedUser));
    }

    public void updateParticipant() {
        participantService.updateParticipant(participantModel.getParticipant());
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Updated Participant");
        facesContext.addMessage(null, facesMessage);
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            String nameLoggedUser = facesContext.getExternalContext().getRemoteUser();

            final String PATH_TO_SAVE_IMAGES = "/home/sergio/uploaded/images"; //Unix

            File targetFolder = new File(PATH_TO_SAVE_IMAGES);
            UploadedFile inImage = event.getFile();
            InputStream inputStream = inImage.getInputstream();

            String newFileName = getFileName(inImage.getFileName(), nameLoggedUser);
            File newImage = new File(targetFolder, newFileName);
            OutputStream outStream = new FileOutputStream(newImage);

            File currentImage = new File(targetFolder.getPath() + "/" + participantModel.getParticipant().getImage_url());

            // If the new image has an extension that is not equal to current, then, erase the current image
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

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesful", inImage.getFileName() + " is uploaded.");
            facesContext.addMessage(null, msg);
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

    public void deleteParticipant() {
        participantService.deleteParticipant(participantModel.getParticipant());
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesful", "Removed Participant");
        facesContext.addMessage(null, msg);
    }
}
