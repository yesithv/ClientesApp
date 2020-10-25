/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanVarios;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import login.ServiciosLogin;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import mapeo.AaUsuario;


/**
 *
 * @author YesithV
 */
@ManagedBean
@ViewScoped
public class MbLogin implements Serializable {

    private AaUsuario usuarioLogin;
    private String focoPagina;

    @EJB(beanName = "SeerviciosLoginImpl")
    private ServiciosLogin serviciosLogin;

    @PostConstruct
    public void init() {
        this.setFocoPagina("itUsuario");
        this.setUsuarioLogin(new AaUsuario());
    }

    /**
     * Metodo encargado de validar el login del usuario
     *
     * @throws IOException
     */
    public void validarUsuario() throws IOException {

        AaUsuario personaLogueada = this.serviciosLogin.validarLogin(this.getUsuarioLogin());
        if (personaLogueada != null) {
            // Subo el usuario a la Sesion
            Utilidades.subiraSession("PersonaEnSession", personaLogueada);
            // Redirecciono:
            Utilidades.redireccionar("dashboard.xhtml");

        } else {
            // fix:
           // RequestContext.getCurrentInstance().update("growl");
            this.setFocoPagina("itUsuario");
            //RequestContext.getCurrentInstance().update("focus");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Información", "Usuario y/o contraseña incorrectos, intente nuevamente"));
        }
    }

    public String getFocoPagina() {
        return focoPagina;
    }

    public void setFocoPagina(String focoPagina) {
        this.focoPagina = focoPagina;
    }

    public AaUsuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(AaUsuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

}
