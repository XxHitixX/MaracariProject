/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claseAux;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ana Sofia
 */
public class filtroUrl implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        
        //capturamos el nombre de la pagina actual
        String currentPage = facesContext.getViewRoot().getViewId();
        
        //Creamos una variable booleana para verificar si fue la pagina de login lo que se capturo
        boolean isPageLogin = currentPage.lastIndexOf("Login.xhtml") >  -1 ? true : false;
        
        HttpSession session =  (HttpSession) facesContext.getExternalContext().getSession(true);
        /*
        recuperamos el objeto String que se guardo para ello,  se toma de la session al usuario login que se definio en 
        el loginBean
        */
        Object usuario = session.getAttribute("usuario");
        
        if(!isPageLogin && usuario==null){//si no es la pagina y el usuario es nulo lo redirigimos a la pagina de login
            NavigationHandler nHandler =  facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext, null, "/Login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
      }
    
}
