package com.smorales.headbanging.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloDAO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }
}

