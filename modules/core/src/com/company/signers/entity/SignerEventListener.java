package com.company.signers.entity;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;

@Component("signers_SignerEventListener")
public class SignerEventListener implements BeforeInsertEntityListener<Signer>, BeforeUpdateEntityListener<Signer> {

    @Override
    public void onBeforeInsert(Signer entity, EntityManager entityManager) {
        entity.setName(Encrypt(entity.getName()));
        entity.setSurname(Encrypt(entity.getSurname()));
        entity.setMiddlename(Encrypt(entity.getMiddlename()));
        entity.setOrganization(Encrypt(entity.getOrganization()));
        entity.setDate(Encrypt(entity.getDate()));
    }


    @Override
    public void onBeforeUpdate(Signer entity, EntityManager entityManager) {
        entity.setName(Encrypt(entity.getName()));
        entity.setSurname(Encrypt(entity.getSurname()));
        entity.setMiddlename(Encrypt(entity.getMiddlename()));
        entity.setOrganization(Encrypt(entity.getOrganization()));
        entity.setDate(Encrypt(entity.getDate()));
    }



    private String Encrypt(String string){return (new StringBuilder(string).reverse()).toString();}
}