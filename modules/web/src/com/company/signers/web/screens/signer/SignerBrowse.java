package com.company.signers.web.screens.signer;

import com.google.common.base.Strings;
import com.haulmont.cuba.core.global.Security;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.signers.entity.Signer;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@UiController("signers_Signer.browse")
@UiDescriptor("signer-browse.xml")
@LookupComponent("signersTable")
@LoadDataBeforeShow
public class SignerBrowse extends StandardLookup<Signer> {

    private List<String> AllowedRoles = Arrays.asList("Decrypt Reader","Administrators");

    @Inject
    private CollectionLoader<Signer> signersDl;
    @Inject
    private UserSession userSession;



    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        if(!Collections.disjoint(userSession.getRoles(),AllowedRoles)) {
            signersDl.load();
            CollectionContainer<Signer> CC =signersDl.getContainer();
            List<Signer> SignersList = CC.getItems();
            for(Signer s: SignersList) {
                s.setDate(Decrypt(s.getDate()));
                s.setName(Decrypt(s.getName()));
                s.setMidllename(Decrypt(s.getMidllename()));
                s.setSurname(Decrypt(s.getSurname()));
                s.setOrganization(Decrypt(s.getOrganization()));
            }
        }

    }



    private String Decrypt(String string){
        return (new StringBuilder(string).reverse()).toString();
    }

}