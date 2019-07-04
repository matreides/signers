package com.company.signers.web.screens.signer;

import com.haulmont.cuba.gui.screen.*;
import com.company.signers.entity.Signer;

@UiController("signers_Signer.edit")
@UiDescriptor("signer-edit.xml")
@EditedEntityContainer("signerDc")
@LoadDataBeforeShow
public class SignerEdit extends StandardEditor<Signer> {
}