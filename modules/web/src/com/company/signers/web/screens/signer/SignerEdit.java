package com.company.signers.web.screens.signer;

import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.signers.entity.Signer;

import javax.inject.Inject;

@UiController("signers_Signer.edit")
@UiDescriptor("signer-edit.xml")
@EditedEntityContainer("signerDc")
@LoadDataBeforeShow
public class SignerEdit extends StandardEditor<Signer> {


    @Inject
    private InstanceContainer<Signer> signerDc;

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

    }

}