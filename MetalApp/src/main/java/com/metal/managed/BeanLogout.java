package com.metal.managed;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
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
