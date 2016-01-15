package com.smorales.headbanging.business.control;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named
public class Logout implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    FacesContext facesContext;

    public String doLogout() {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        return "/index.xhtml?faces-redirect=true";
    }
}
