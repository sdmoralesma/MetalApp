package com.metal.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.metal.model.Participant;

/**
 * Permite a un participante ver su propio perfil y modificarlo
 */
@Named
@Stateless
public class ParticipantBean {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	@Inject
	private Participant participant;

	public static final String PATH_TO_SAVE_IMAGES = "/home/sergio/uploaded/images";

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

	private String getFileName(String fileName, String userName) {
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return userName + "." + extension;
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
			File targetFolder = new File(PATH_TO_SAVE_IMAGES);
			UploadedFile inImage = event.getFile();
			InputStream inputStream = inImage.getInputstream();

			String newFileName = getFileName(inImage.getFileName(), nameLoggedUser);
			File newImage = new File(targetFolder, newFileName);
			OutputStream outStream = new FileOutputStream(newImage);

			File currentImage = new File(targetFolder.getPath() + "/" + participant.getImage_url());

			// Si la imagen que llega tiene una extension distinta a la actual,
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
}
