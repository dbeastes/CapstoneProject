/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.j2ee.capstone.model;

/**
 *
 * @author dustineastes
 */
public class FailBean {
    private String emailFail;
    private String passFail;
    private String fNameFail;
    private String lNameFail;
    private String passwordFail;
    private boolean noErrors;
    /**
     * @return the emailFail
     */
    public String getEmailFail() {
        return emailFail;
    }

    /**
     * @return the passFail
     */
    public String getPassFail() {
        return passFail;
    }

    /**
     * @param emailFail the emailFail to set
     */
    public void setEmailFail(String emailFail) {
        this.emailFail = emailFail;
    }

    /**
     * @param passFail the passFail to set
     */
    public void setPassFail(String passFail) {
        this.passFail = passFail;
    }

    /**
     * @return the fNameFail
     */
    public String getfNameFail() {
        return fNameFail;
    }

    /**
     * @return the lNameFail
     */
    public String getlNameFail() {
        return lNameFail;
    }

    /**
     * @return the passwordFail
     */
    public String getPasswordFail() {
        return passwordFail;
    }

    /**
     * @param fNameFail the fNameFail to set
     */
    public void setfNameFail(String fNameFail) {
        this.fNameFail = fNameFail;
    }

    /**
     * @param lNameFail the lNameFail to set
     */
    public void setlNameFail(String lNameFail) {
        this.lNameFail = lNameFail;
    }

    /**
     * @param passwordFail the passwordFail to set
     */
    public void setPasswordFail(String passwordFail) {
        this.passwordFail = passwordFail;
    }

    /**
     * @return the noErrors
     */
    public boolean isNoErrors() {
        return noErrors;
    }

    /**
     * @param noErrors the noErrors to set
     */
    public void setNoErrors(boolean noErrors) {
        this.noErrors = noErrors;
    }
    
}
