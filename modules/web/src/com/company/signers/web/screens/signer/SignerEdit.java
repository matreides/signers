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
        DecryptEntity();
    }

    @Subscribe
    private void onBeforeClose(BeforeCloseEvent event) {
        DecryptEntity();
    }

    private void DecryptEntity(){
        Signer s = signerDc.getItem();
        if(s.getName() != null && !Collections.disjoint(userSession.getRoles(),AllowedRoles)) {
            s.Decrypt();
        }
    }


}