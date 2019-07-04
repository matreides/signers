package com.company.signers.entity;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("signers_SignerEventListener")
public class SignerEventListener implements BeforeInsertEntityListener<Signer>, BeforeUpdateEntityListener<Signer> {

    @EventListener
    private void beforeCommit(EntityChangedEvent<Signer, UUID> event) {

    }

    @Override
    public void onBeforeInsert(Signer entity, EntityManager entityManager) {
        entity.setName(Encrypt(entity.getName()));
        entity.setSurname(Encrypt(entity.getSurname()));
        entity.setMidllename(Encrypt(entity.getMidllename()));
        entity.setOrganization(Encrypt(entity.getOrganization()));
        entity.setDate(Encrypt(entity.getDate()));
    }

    @Override
    public void onBeforeUpdate(Signer entity, EntityManager entityManager) {

    }

    private String Encrypt(String string){return (new StringBuilder(string).reverse()).toString();}
}