package com.company.signers.web.screens.signer;

import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.signers.entity.Signer;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UiController("signers_Signer.edit")
@UiDescriptor("signer-edit.xml")
@EditedEntityContainer("signerDc")
@LoadDataBeforeShow
public class SignerEdit extends StandardEditor<Signer> {


    private List<String> AllowedRoles = Arrays.asList("Decrypt Reader","Administrators");

    @Inject
    private InstanceContainer<Signer> signerDc;
    @Inject
    private UserSession userSession;


    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        if(signerDc.getItem().getName() != null && !Collections.disjoint(userSession.getRoles(),AllowedRoles)) {
            signerDc.setItem(DecryptEntity((signerDc.getItem())));
        }
    }

    @Subscribe
    private void onBeforeClose(BeforeCloseEvent event) {
        if(signerDc.getItem().getName() != null && !Collections.disjoint(userSession.getRoles(),AllowedRoles))
            signerDc.setItem(DecryptEntity(signerDc.getItem()));
    }

    private Signer DecryptEntity(Signer entity){
        entity.setDate(Decrypt(entity.getDate()));
        entity.setName(Decrypt(entity.getName()));
        entity.setMiddlename(Decrypt(entity.getMiddlename()));
        entity.setSurname(Decrypt(entity.getSurname()));
        entity.setOrganization(Decrypt(entity.getOrganization()));
        return entity;
    }

    private String Decrypt(String string){
        return (new StringBuilder(string).reverse()).toString();
    }



}