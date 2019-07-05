package com.company.signers.web.screens.signer;

import com.haulmont.cuba.gui.model.CollectionContainer;
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
            Signer s = signerDc.getItem();
            s.setDate(Decrypt(s.getDate()));
            s.setName(Decrypt(s.getName()));
            s.setMidllename(Decrypt(s.getMidllename()));
            s.setSurname(Decrypt(s.getSurname()));
            s.setOrganization(Decrypt(s.getOrganization()));
            signerDc.setItem(s);
        }
    }

    private String Decrypt(String string){
        return (new StringBuilder(string).reverse()).toString();
    }



}