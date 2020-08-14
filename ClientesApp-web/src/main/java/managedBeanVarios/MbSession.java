/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanVarios;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author YesithV
 */
@ManagedBean(name = "mbSession")
@ViewScoped
@Any
public class MbSession implements Serializable {

    private Integer tiempoMostrarDialogo;
    private Integer tiempoTerminaSesion;

    @PostConstruct
    public void init() {
        int segundos = 3600; // 3600 segundos = 1 hora
        this.setTiempoMostrarDialogo(segundos * 1000);
    }

    public Integer getTiempoMostrarDialogo() {
        return tiempoMostrarDialogo;
    }

    public void setTiempoMostrarDialogo(Integer tiempoMostrarDialogo) {
        this.tiempoMostrarDialogo = tiempoMostrarDialogo;
    }

    public Integer getTiempoTerminaSesion() {
        return tiempoTerminaSesion;
    }

    public void redireccionar() throws IOException {
        Utilidades.redireccionar("login.xhtml");
    }

}
