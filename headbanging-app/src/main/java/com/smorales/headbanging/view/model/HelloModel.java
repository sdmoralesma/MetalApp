package com.smorales.headbanging.view.model;

import javax.inject.Named;

@Named
public class HelloModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

