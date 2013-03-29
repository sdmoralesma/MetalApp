package com.metal.managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.metal.ejb.FacadeEJB;
import com.metal.model.Jury;

@ManagedBean
@RequestScoped
public class BeanRegisterJury {

	@EJB
	private FacadeEJB facade;

	private Jury jury = new Jury();
	private List<Jury> juryList = new ArrayList<>();

	public String doCreateJury() {
		facade.registerJury(jury);
		juryList = facade.findJuries();
		return "registerJury.xhtml";
	}

	// Getters y Setters
	public Jury getJury() {
		return jury;
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}

	public List<Jury> getJuryList() {
		return juryList;
	}

	public void setJuryList(List<Jury> juryList) {
		this.juryList = juryList;
	}
}
