package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u"),
        @NamedQuery(name = User.FIND_ALL_BY_TYPE, query = "SELECT u FROM User u WHERE TYPE(u) = :type")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "User.findAllUsers";
    public static final String FIND_ALL_BY_TYPE = "User.findAllByType";

    @Id
    @Column(unique = true, nullable = false, length = 50)
    @Size(min = 3, max = 25)
    private String username;

    @Column(nullable = false, length = 50)
    private String group_name;

    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 20)
    private String password;

    public User() {
    }

    public User(String username, String group_name, String password) {
        this.username = username;
        this.group_name = group_name;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroup() {
        return this.group_name;
    }

    public void setGroup(String group_name) {
        this.group_name = group_name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}