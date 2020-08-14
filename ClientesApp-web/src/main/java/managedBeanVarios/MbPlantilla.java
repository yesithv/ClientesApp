/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanVarios;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mapeo.AaUsuario;

/**
 *
 * @author YesithV
 */
@ManagedBean(name = "mbPlantilla")
@ViewScoped
@Any
//@SessionScoped
public class MbPlantilla implements Serializable {

    private AaUsuario personaLogueada;
    private String edadPersonaLogueada;

    @PostConstruct
    public void init() {
        //Bajo el usuario de la session:
        this.setPersonaLogueada((AaUsuario) Utilidades.bajardeSession("PersonaEnSession"));
    }

    /**
     * Metodo encargado de cerrar la sesion del usuario y redireccionar
     */
    public void salir() {
        // Elimino el objeto de sesion:
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        try {
            // Redirecciono
            FacesContext.getCurrentInstance().getExternalContext().redirect(Utilidades.getUrl() + "login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(MbPlantilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEdadPersonaLogueada() {
        return edadPersonaLogueada;
    }

    public void setEdadPersonaLogueada(String edadPersonaLogueada) {
        this.edadPersonaLogueada = edadPersonaLogueada;
    }

    public AaUsuario getPersonaLogueada() {
        return personaLogueada;
    }

    public void setPersonaLogueada(AaUsuario personaLogueada) {
        this.personaLogueada = personaLogueada;
    }

}
