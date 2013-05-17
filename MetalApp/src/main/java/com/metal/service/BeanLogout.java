package com.metal.service;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
public class BeanLogout implements Serializable {

	/***/
	private static final long serialVersionUID = 1L;

	public String doLogout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();
		return "/index.xhtml?faces-redirect=true";
	}
}