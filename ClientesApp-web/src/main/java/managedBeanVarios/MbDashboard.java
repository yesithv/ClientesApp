/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanVarios;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author YesithV
 */
@ManagedBean(name = "mbDashboard")
@ViewScoped
public class MbDashboard extends MbGeneral implements Serializable {

    @PostConstruct
    public void iniciar() {

        // SE VALIDA QUE EL USUARIO ESTÉ LOGUEADO:
        if (this.getPersonaEnSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            try {
                Utilidades.redireccionar("login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(MbDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
    }

}
