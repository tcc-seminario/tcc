/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgsg.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author neillon
 */
public class FacesUtil {

    public static void AddMensagemInfo(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, facesMessage);
    }

    public static void AddMensagemErro(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, facesMessage);
    }
}
