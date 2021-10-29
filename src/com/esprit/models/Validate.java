/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

/**
 *
 * @author stef info
 */
public class Validate {
  private String validate;

    private String username;

    public Validate(String validate, String username) {
        this.validate = validate;
        this.username = username;
    }
    

   
    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Validate{" + "validate=" + validate + ", username=" + username + '}';
    }

}