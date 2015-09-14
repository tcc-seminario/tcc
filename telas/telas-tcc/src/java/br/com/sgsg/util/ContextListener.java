/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgsg.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.Session;

/**
 *
 * @author neillon
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory().openSession(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory().close(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
