package com.company.signers.entity;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;


@Component("signers_SignerEventListener")
public class SignerEventListener implements BeforeInsertEntityListener<Signer>, BeforeUpdateEntityListener<Signer>{

    @Override
    public void onBeforeInsert(Signer entity, EntityManager entityManager) {
        entity.Encrypt();
    }


    @Override
    public void onBeforeUpdate(Signer entity, EntityManager entityManager) {
        entity.Encrypt();
    }
}