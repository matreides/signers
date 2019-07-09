package com.company.signers.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Table(name = "SIGNERS_SIGNER")
@Entity(name = "signers_Signer")
@Listeners("signers_SignerEventListener")
@NamePattern("%s|name")
public class Signer extends StandardEntity {
    private static final long serialVersionUID = -3879742723859709191L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "MIDDLENAME", nullable = false)
    protected String middlename;

    @NotNull
    @Column(name = "SURNAME", nullable = false)
    protected String surname;

    @NotNull
    @Column(name = "ORGANIZATION", nullable = false)
    protected String organization;

    @NotNull
    @Column(name = "DATE_", nullable = false)
    protected String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganization() { return organization; }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Encrypt(){
        try {
            name = EncryptString(name);
            middlename = EncryptString(middlename);
            surname = EncryptString(surname);
            organization = EncryptString(organization);
            date = EncryptString(date);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e){
            e.getStackTrace();
        }
    }

    public void Decrypt(){
        try {
            setName(DecryptString(name));
            setMiddlename(DecryptString(middlename));
            setSurname(DecryptString(surname));
            setOrganization(DecryptString(organization));
            setDate(DecryptString(date));
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e){
            e.getStackTrace();
        }
    }


    private static String EncryptString(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String keystr = "2GQ14SLAcDn8K7FirvlM5VTvVpr8jyBJ";
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey key = new SecretKeySpec(keystr.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private static String DecryptString(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String keystr = "2GQ14SLAcDn8K7FirvlM5VTvVpr8jyBJ";
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey key = new SecretKeySpec(keystr.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decrypted = Base64.getDecoder().decode(str);
        return new String(cipher.doFinal(decrypted));
    }
}