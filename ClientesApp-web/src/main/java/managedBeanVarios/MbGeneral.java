/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanVarios;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import mapeo.AaUsuario;

/**
 *
 * @author YesithV
 */
public class MbGeneral implements Serializable {

    private AaUsuario personaEnSesion;

    public MbGeneral() {

    }

    @PostConstruct
    public void postConstruct() {
        this.setPersonaEnSesion((AaUsuario) Utilidades.bajardeSession("PersonaEnSession"));

    }

    public AaUsuario getPersonaEnSesion() {
        return personaEnSesion;
    }

    public void setPersonaEnSesion(AaUsuario personaEnSesion) {
        this.personaEnSesion = personaEnSesion;
    }

}
