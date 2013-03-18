package com.metal.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class Facade {

	@EJB
	private ServiceAdmin serviceAdmin;
	@EJB
	private ServiceJury serviceJury;
	@EJB
	private ServiceScore serviceScore;

	
	/**
	 * Default constructor.
	 */
	public Facade() {
		
	}
	

}
