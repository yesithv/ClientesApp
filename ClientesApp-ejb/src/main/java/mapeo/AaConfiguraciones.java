/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_configuraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaConfiguraciones.findAll", query = "SELECT a FROM AaConfiguraciones a")
    , @NamedQuery(name = "AaConfiguraciones.findByIdconfiguracion", query = "SELECT a FROM AaConfiguraciones a WHERE a.idconfiguracion = :idconfiguracion")
    , @NamedQuery(name = "AaConfiguraciones.findByActiva", query = "SELECT a FROM AaConfiguraciones a WHERE a.activa = :activa")
    , @NamedQuery(name = "AaConfiguraciones.findByNumerodehijos", query = "SELECT a FROM AaConfiguraciones a WHERE a.numerodehijos = :numerodehijos")
    , @NamedQuery(name = "AaConfiguraciones.findByValorminimocalificar", query = "SELECT a FROM AaConfiguraciones a WHERE a.valorminimocalificar = :valorminimocalificar")
    , @NamedQuery(name = "AaConfiguraciones.findByTecho", query = "SELECT a FROM AaConfiguraciones a WHERE a.techo = :techo")
    , @NamedQuery(name = "AaConfiguraciones.findByFechaactivacion", query = "SELECT a FROM AaConfiguraciones a WHERE a.fechaactivacion = :fechaactivacion")
    , @NamedQuery(name = "AaConfiguraciones.findByFechadesactivacion", query = "SELECT a FROM AaConfiguraciones a WHERE a.fechadesactivacion = :fechadesactivacion")})
public class AaConfiguraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconfiguracion")
    private Integer idconfiguracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa")
    private short activa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerodehijos")
    private int numerodehijos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorminimocalificar")
    private int valorminimocalificar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "techo")
    private int techo;
    @Column(name = "fechaactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaactivacion;
    @Column(name = "fechadesactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadesactivacion;

    public AaConfiguraciones() {
    }

    public AaConfiguraciones(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public AaConfiguraciones(Integer idconfiguracion, short activa, int numerodehijos, int valorminimocalificar, int techo) {
        this.idconfiguracion = idconfiguracion;
        this.activa = activa;
        this.numerodehijos = numerodehijos;
        this.valorminimocalificar = valorminimocalificar;
        this.techo = techo;
    }

    public Integer getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public short getActiva() {
        return activa;
    }

    public void setActiva(short activa) {
        this.activa = activa;
    }

    public int getNumerodehijos() {
        return numerodehijos;
    }

    public void setNumerodehijos(int numerodehijos) {
        this.numerodehijos = numerodehijos;
    }

    public int getValorminimocalificar() {
        return valorminimocalificar;
    }

    public void setValorminimocalificar(int valorminimocalificar) {
        this.valorminimocalificar = valorminimocalificar;
    }

    public int getTecho() {
        return techo;
    }

    public void setTecho(int techo) {
        this.techo = techo;
    }

    public Date getFechaactivacion() {
        return fechaactivacion;
    }

    public void setFechaactivacion(Date fechaactivacion) {
        this.fechaactivacion = fechaactivacion;
    }

    public Date getFechadesactivacion() {
        return fechadesactivacion;
    }

    public void setFechadesactivacion(Date fechadesactivacion) {
        this.fechadesactivacion = fechadesactivacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconfiguracion != null ? idconfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaConfiguraciones)) {
            return false;
        }
        AaConfiguraciones other = (AaConfiguraciones) object;
        if ((this.idconfiguracion == null && other.idconfiguracion != null) || (this.idconfiguracion != null && !this.idconfiguracion.equals(other.idconfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaConfiguraciones[ idconfiguracion=" + idconfiguracion + " ]";
    }
    
}
