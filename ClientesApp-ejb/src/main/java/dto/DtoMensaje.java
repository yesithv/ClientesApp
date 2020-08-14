/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import enumerados.EtipoPantalla;
import java.io.Serializable;
import javax.faces.application.FacesMessage.Severity;

/**
 *
 * @author YesithV
 */
public class DtoMensaje implements Serializable {

    private boolean activo;
    private Severity gravedad;
    private String resumen;
    private String detalle;
    private EtipoPantalla noMostrarMensajeEn;

    public DtoMensaje() {
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Severity getGravedad() {
        return gravedad;
    }

    public void setGravedad(Severity gravedad) {
        this.gravedad = gravedad;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public EtipoPantalla getNoMostrarMensajeEn() {
        return noMostrarMensajeEn;
    }

    public void setNoMostrarMensajeEn(EtipoPantalla noMostrarMensajeEn) {
        this.noMostrarMensajeEn = noMostrarMensajeEn;
    }

}
