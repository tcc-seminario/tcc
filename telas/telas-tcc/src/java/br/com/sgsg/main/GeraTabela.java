/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgsg.main;

import br.com.sgsg.util.HibernateUtil;

/**
 *
 * @author Neillon
 */
public class GeraTabela {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
}
