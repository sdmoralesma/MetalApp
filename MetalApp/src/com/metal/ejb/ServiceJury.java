package com.metal.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.metal.model.Jury;

/**
 * Vota por Concursante y Vota por Cancion
 */
@Stateless
@LocalBean
public class ServiceJury {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	/** Default constructor. */
	public ServiceJury() {
		super();
	}

	// Votar por Concursante
	public Jury findJuryById(Long id) {
		return em.find(Jury.class, id);
	}

	public Jury createJury(Jury jury) {
		em.persist(jury);
		return jury;
	}

	public void deleteJury(Jury jury) {
		em.remove(em.merge(jury));
	}

	public Jury updateJury(Jury jury) {
		return em.merge(jury);
	}

}
