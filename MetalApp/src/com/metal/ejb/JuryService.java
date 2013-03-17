package com.metal.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.metal.model.Jury;

/**
 * Vota por Concursante y Vota por Cancion
 */
@Stateless
@LocalBean
public class JuryService {
       
    /**
     * @see Jury#Jury()
     */
    public JuryService() {
        super();
        // TODO Auto-generated constructor stub
    }

}
