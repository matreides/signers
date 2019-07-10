package com.company.signers.web.screens.signer;

import com.haulmont.cuba.gui.components.Window;
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

    //Список ролей, которые могут видеть расшифрованый текст
    private List<String> AllowedRoles = Arrays.asList("Decrypt Reader","Administrators");

    @Inject
    private InstanceContainer<Signer> signerDc;
    @Inject
    private UserSession userSession;


    //После отображения страницы, сущность в контейнере расшифровывается
    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        DecryptEntity();
    }

    //После закрытия страницы и сохранения изменений, сущность в контейнере расшифровывается
    @Subscribe
    private void onAfterClose(BeforeCloseEvent event) {
        if(!event.isClosePrevented())
            try{
            DecryptEntity();
            }
        catch (IllegalArgumentException e){}

    }



    //Метод проверяет
    //1) наличие сущности в контейнере
    //2) соответсвие роли пользователя
    //и после этого расшифровывает сущность
    private void DecryptEntity(){
        Signer s = signerDc.getItem();
        if(s.getName() != null && !Collections.disjoint(userSession.getRoles(),AllowedRoles)) {
            s.Decrypt();
        }
    }


}