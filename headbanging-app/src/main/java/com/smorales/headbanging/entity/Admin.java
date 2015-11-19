package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@NamedQueries({
        @NamedQuery(name = Admin.findAll, query = "SELECT a FROM Admin a"),
        @NamedQuery(name = Admin.findByName, query = "SELECT a FROM Admin a WHERE a.name = :name"),
        @NamedQuery(name = Admin.findByUsername, query = "SELECT a FROM Admin a WHERE a.username = :username")
})
public class Admin extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "Admin";
    public static final String findAll = PREFIX + ".findAll";
    public static final String findByName = PREFIX + ".findByName";
    public static final String findByUsername = PREFIX + ".findByUsername";

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "admin_info")
    private String adminInfo;


    public String getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(String adminInfo) {
        this.adminInfo = adminInfo;
    }   
}
