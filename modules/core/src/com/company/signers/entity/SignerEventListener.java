package com.company.signers.entity;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;

//Слушатель сущности "Подписант"
@Component("signers_SignerEventListener")
public class SignerEventListener implements BeforeInsertEntityListener<Signer>, BeforeUpdateEntityListener<Signer>{

    //Перед вставкой сущности в БД, зашифровывает её поля
    @Override
    public void onBeforeInsert(Signer entity, EntityManager entityManager) {
        entity.Encrypt();
    }

    //Перед обнавление сущности в БД, зашифровыает её поля
    @Override
    public void onBeforeUpdate(Signer entity, EntityManager entityManager) {
        entity.Encrypt();
    }
}