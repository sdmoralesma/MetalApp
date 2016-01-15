package com.smorales.headbanging.business.control;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

@RequestScoped
public class FacesContextExposer {

    @Produces
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}