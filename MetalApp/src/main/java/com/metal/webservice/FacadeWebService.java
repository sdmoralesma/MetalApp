package com.metal.webservice;

/**
 * Session Bean implementation class WebServiceFacade
 */
// @WebService
// @Stateless
// @LocalBean
public class FacadeWebService {

	// public List<Participant> getRatingParticipants() {
	// System.out.println("WS RatingParticipants");
	// return null;
	// }

	// public List<Song> getRatingSongs() {
	// System.out.println("WS RatingSongs");
	// return null;
	// }

	// public Participant getRatingPerParticipant(@WebParam Participant
	// participant) {
	// System.out.println("WS RatingPerParticipant");
	// return null;
	// }

	public String animalType(String animal) {
		String animalType = "";
		if ("Lion".equals(animal)) {
			animalType = "Wild";
		} else if ("Dog".equals(animal)) {
			animalType = "Domestic";
		} else {
			animalType = "I don't know!";
		}
		return animalType;
	}

}
