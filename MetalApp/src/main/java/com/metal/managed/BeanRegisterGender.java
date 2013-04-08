package com.metal.managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.metal.ejb.FacadeEJB;
import com.metal.model.Gender;

@ManagedBean
@RequestScoped
public class BeanRegisterGender {

	@EJB
	private FacadeEJB facade;

	private Gender gender = new Gender();
	private List<Gender> genderList = new ArrayList<>();

	@PostConstruct
	public void populateGenderList() {
		this.genderList = facade.findGenders();
	}

	public String doCreateGender() {
		facade.registerGender(gender);
		genderList = facade.findGenders();
		return "registerGender.xhtml";
	}

	// Getters y Setters
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Gender> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Gender> genderList) {
		this.genderList = genderList;
	}
}
