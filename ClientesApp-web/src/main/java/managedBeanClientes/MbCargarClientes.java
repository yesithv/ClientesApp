/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanClientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import managedBeanVarios.MbGeneral;
import managedBeanVarios.Utilidades;
import mapeo.AaCargasclientes;
import mapeo.AaClientes;
import mapeo.AaUsuario;
import mapeo.Terceros;
import servicios.ServiciosCarga;
import servicios.ServiciosVarios;

/**
 *
 * @author YesithV
 */
@ManagedBean
@ViewScoped
public class MbCargarClientes extends MbGeneral implements Serializable {
    
    private AaCargasclientes ultimosDatos;
    private String observaciones;
    private List<Terceros> tercerosList;
    
    @EJB(beanName = "ServiciosCargaImpl")
    private ServiciosCarga ServiciosCarga;
    
    @EJB(beanName = "ServiciosVariosImpl")
    private ServiciosVarios serviciosVarios;
    
    @PostConstruct
    public void init() {
        this.setUltimosDatos(this.ServiciosCarga.buscarUltimaCarga());
        this.setTercerosList(new ArrayList<Terceros>());
    }
    
    public void buscarTercerosSinCargar() {
        if (this.getUltimosDatos() == null) {
            // Es la primera vez que se cargan clientes
            this.setTercerosList(this.ServiciosCarga.tercerosList(0));
        } else {
            this.setTercerosList(this.ServiciosCarga.tercerosList(ultimosDatos.getFkultimocliente().getIdtercero()));
        }
    }
    
    public void cargarTercerosAClientesApp() {
        this.buscarTercerosSinCargar();
        AaClientes cliente;
        for (Terceros tercero : this.getTercerosList()) {
            cliente = new AaClientes();
            cliente.setIdtercero(tercero.getIdtercero());
            cliente.setNumerodocumento(tercero.getNit().replaceAll("\\s",""));
            cliente.setNombresyapellidos(tercero.getNombres().concat(tercero.getNombre2()).concat(tercero.getApellidos()).concat(tercero.getApellido2()));
            cliente.setActivo(Short.valueOf("1"));
            this.serviciosVarios.guardarObjeto(cliente);
        }
        AaCargasclientes nuevaCarga = new AaCargasclientes();
        nuevaCarga.setFechacarga(Utilidades.getFechaActualDate());
        // Primer cliente
        AaClientes primerCliente = new AaClientes();
        primerCliente.setIdtercero(this.getTercerosList().get(0).getIdtercero());
        nuevaCarga.setFkprimercliente(primerCliente);
        // Ultimo Cliente
        AaClientes ultimoCliente = new AaClientes();
        ultimoCliente.setIdtercero(this.getTercerosList().get(this.getTercerosList().size() - 1).getIdtercero());
        nuevaCarga.setFkultimocliente(ultimoCliente);
        // Usuario que carga
        AaUsuario usuarioCarga = new AaUsuario();
        usuarioCarga.setIdusuario(this.getPersonaEnSesion().getIdusuario());
        nuevaCarga.setFkusuariocarga(usuarioCarga);
        // Observaciones y Guardar
        nuevaCarga.setObservaciones(this.getObservaciones());
        this.serviciosVarios.guardarObjeto(nuevaCarga);
        
        this.reIniciarDatos();
    }
    
    private void reIniciarDatos() {
        this.setUltimosDatos(new AaCargasclientes());
        this.setTercerosList(new ArrayList<Terceros>());
        this.setObservaciones("");
        this.init();
        
    }
    
    public AaCargasclientes getUltimosDatos() {
        return ultimosDatos;
    }
    
    public void setUltimosDatos(AaCargasclientes ultimosDatos) {
        this.ultimosDatos = ultimosDatos;
    }
    
    public List<Terceros> getTercerosList() {
        return tercerosList;
    }
    
    public void setTercerosList(List<Terceros> tercerosList) {
        this.tercerosList = tercerosList;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
