/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.ejb.Remote;
import mapeo.AaUsuario;

/**
 *
 * @author YesithV
 */
@Remote
public interface ServiciosLogin {

    AaUsuario validarLogin(AaUsuario usuarioValidar);

}
