/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import com.dao.LoginDAO;
import com.dao.LoginDAOLocal;
import com.model.Login;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tiago
 */
@ManagedBean
@SessionScoped
public class LoginMB {

    @EJB
    private LoginDAOLocal loginDao;

    private Login login = new Login();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String logar() {
        boolean check = loginDao.checkUser(login.getUserName(), login.getPassword());

        if (check) {
            return "index";
        } else {
            return "erro";
        }

    }

    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {
    }

}
