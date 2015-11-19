package com.smorales.headbanging.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "jury")
@DiscriminatorValue("JURY")
@PrimaryKeyJoinColumn(name = "jury_id")
public class Jury extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 100)
    @Column(name = "jury_info")
    private String juryInfo;

    @JoinColumn(name = "presentation_id", referencedColumnName = "id_presentation")
    @ManyToOne
    private Presentation presentationId;

    public String getJuryInfo() {
        return juryInfo;
    }

    public void setJuryInfo(String juryInfo) {
        this.juryInfo = juryInfo;
    }

    public Presentation getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Presentation presentationId) {
        this.presentationId = presentationId;
    }

}
