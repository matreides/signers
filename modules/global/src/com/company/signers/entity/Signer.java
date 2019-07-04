package com.company.signers.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@PublishEntityChangedEvents
@Table(name = "SIGNERS_SIGNER")
@Entity(name = "signers_Signer")
@Listeners("signers_SignerEventListener")
public class Signer extends StandardEntity {
    private static final long serialVersionUID = -3879742723859709191L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "MIDLLENAME", nullable = false)
    protected String midllename;

    @NotNull
    @Column(name = "SURNAME", nullable = false)
    protected String surname;

    @NotNull
    @Column(name = "ORGANIZATION", nullable = false)
    protected String organization;

    @NotNull
    @Column(name = "DATE_", nullable = false)
    protected String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganization() { return organization; }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMidllename() {
        return midllename;
    }

    public void setMidllename(String midllename) {
        this.midllename = midllename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}