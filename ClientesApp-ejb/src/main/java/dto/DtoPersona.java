/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author YesithV
 */
public class DtoPersona implements Serializable {

    private Integer documento;
    private String password;
    private Boolean activo;
    private String nombre;
    private Integer ciudadResidencia;
    private Integer estado;
    private String telefonoPrincipal;
    private String telefonoAlterno;
    private String email;
    private String direccionresidencia;
    private String observacionesRegistro;
    private Integer ciudadAtencion;
    private Integer especialidad;
    private Integer especialista;
    private Integer tipoAtencion;
    private Integer valorPagar;
    private Integer idPuntoAtencion;
    private Integer tipoPaciente;
    private Integer medioDePago;
    private Date proximaCita;

    public DtoPersona() {
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(Integer ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getTelefonoPrincipal() {
        return telefonoPrincipal;
    }

    public void setTelefonoPrincipal(String telefonoPrincipal) {
        this.telefonoPrincipal = telefonoPrincipal;
    }

    public String getTelefonoAlterno() {
        return telefonoAlterno;
    }

    public void setTelefonoAlterno(String telefonoAlterno) {
        this.telefonoAlterno = telefonoAlterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionresidencia() {
        return direccionresidencia;
    }

    public void setDireccionresidencia(String direccionresidencia) {
        this.direccionresidencia = direccionresidencia;
    }

    public String getObservacionesRegistro() {
        return observacionesRegistro;
    }

    public void setObservacionesRegistro(String observacionesRegistro) {
        this.observacionesRegistro = observacionesRegistro;
    }

    public Integer getCiudadAtencion() {
        return ciudadAtencion;
    }

    public void setCiudadAtencion(Integer ciudadAtencion) {
        this.ciudadAtencion = ciudadAtencion;
    }

    public Integer getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(Integer tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public Integer getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Integer valorPagar) {
        this.valorPagar = valorPagar;
    }

    public Integer getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public void setIdPuntoAtencion(Integer idPuntoAtencion) {
        this.idPuntoAtencion = idPuntoAtencion;
    }

    public Integer getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(Integer tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public Integer getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Integer especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Integer especialista) {
        this.especialista = especialista;
    }

    public Integer getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(Integer medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Date getProximaCita() {
        return proximaCita;
    }

    public void setProximaCita(Date proximaCita) {
        this.proximaCita = proximaCita;
    }

    
}
