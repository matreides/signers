package com.company.signers.web.screens.signer;

import com.haulmont.cuba.gui.screen.*;
import com.company.signers.entity.Signer;

@UiController("signers_Signer.browse")
@UiDescriptor("signer-browse.xml")
@LookupComponent("signersTable")
@LoadDataBeforeShow
public class SignerBrowse extends StandardLookup<Signer> {
}