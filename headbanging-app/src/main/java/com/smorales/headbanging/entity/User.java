package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = User.findAll, query = "SELECT u FROM User u"),
        @NamedQuery(name = User.findByUsername, query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = User.findAllByType, query = "SELECT u FROM User u WHERE TYPE(u) = :type")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PREFIX = "User";
    public static final String findAll = PREFIX + ".findAllUsers";
    public static final String findByUsername = PREFIX + ".findByUsername";
    public static final String findAllByType = PREFIX + ".findAllByType";

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(unique = true, nullable = false)
    @Size(min = 1, max = 20)
    private String username;

    @Size(max = 20)
    @Column(name = "user_type")
    private String userType;

    @Size(min = 1, max = 20)
    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy = "userId")
    private Set<Presentation> presentationSet;

    @OneToMany(mappedBy = "userId")
    private Set<ScoreMatrix> scoreMatrixSet;

    @OneToOne(mappedBy = "userId")
    private Jury jurySet;

    @OneToOne(mappedBy = "userId")
    private Admin adminSet;

    @OneToOne(mappedBy = "userId")
    private Participant participantSet;

    public User() {
    }

    public User(String username, String group_name, String password) {
        this.username = username;
        this.groupName = group_name;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Set<Presentation> getPresentationSet() {
        return presentationSet;
    }

    public void setPresentationSet(Set<Presentation> presentationSet) {
        this.presentationSet = presentationSet;
    }

    public Jury getJurySet() {
        return jurySet;
    }

    public void setJurySet(Jury jurySet) {
        this.jurySet = jurySet;
    }

    public Admin getAdminSet() {
        return adminSet;
    }

    public void setAdminSet(Admin adminSet) {
        this.adminSet = adminSet;
    }

    @XmlTransient
    public Set<ScoreMatrix> getScoreMatrixSet() {
        return scoreMatrixSet;
    }

    public void setScoreMatrixSet(Set<ScoreMatrix> scoreMatrixSet) {
        this.scoreMatrixSet = scoreMatrixSet;
    }

    public Participant getParticipantSet() {
        return participantSet;
    }

    public void setParticipantSet(Participant participantSet) {
        this.participantSet = participantSet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smorales.headbanging.entity.User[ userId=" + userId + " ]";
    }

}
