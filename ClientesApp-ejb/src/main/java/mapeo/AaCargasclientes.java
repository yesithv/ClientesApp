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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_cargasclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaCargasclientes.findAll", query = "SELECT a FROM AaCargasclientes a")
    , @NamedQuery(name = "AaCargasclientes.findByIdcargascliente", query = "SELECT a FROM AaCargasclientes a WHERE a.idcargascliente = :idcargascliente")
    , @NamedQuery(name = "AaCargasclientes.findByFechacarga", query = "SELECT a FROM AaCargasclientes a WHERE a.fechacarga = :fechacarga")
    , @NamedQuery(name = "AaCargasclientes.findByIdprimercliente", query = "SELECT a FROM AaCargasclientes a WHERE a.idprimercliente = :idprimercliente")
    , @NamedQuery(name = "AaCargasclientes.findByIdultimocliente", query = "SELECT a FROM AaCargasclientes a WHERE a.idultimocliente = :idultimocliente")
    , @NamedQuery(name = "AaCargasclientes.findByIdusuarioquecarga", query = "SELECT a FROM AaCargasclientes a WHERE a.idusuarioquecarga = :idusuarioquecarga")
    , @NamedQuery(name = "AaCargasclientes.findByObservaciones", query = "SELECT a FROM AaCargasclientes a WHERE a.observaciones = :observaciones")})
public class AaCargasclientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcargascliente")
    private Integer idcargascliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacarga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprimercliente")
    private int idprimercliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idultimocliente")
    private int idultimocliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuarioquecarga")
    private int idusuarioquecarga;
    @Size(max = 60)
    @Column(name = "observaciones")
    private String observaciones;

    public AaCargasclientes() {
    }

    public AaCargasclientes(Integer idcargascliente) {
        this.idcargascliente = idcargascliente;
    }

    public AaCargasclientes(Integer idcargascliente, Date fechacarga, int idprimercliente, int idultimocliente, int idusuarioquecarga) {
        this.idcargascliente = idcargascliente;
        this.fechacarga = fechacarga;
        this.idprimercliente = idprimercliente;
        this.idultimocliente = idultimocliente;
        this.idusuarioquecarga = idusuarioquecarga;
    }

    public Integer getIdcargascliente() {
        return idcargascliente;
    }

    public void setIdcargascliente(Integer idcargascliente) {
        this.idcargascliente = idcargascliente;
    }

    public Date getFechacarga() {
        return fechacarga;
    }

    public void setFechacarga(Date fechacarga) {
        this.fechacarga = fechacarga;
    }

    public int getIdprimercliente() {
        return idprimercliente;
    }

    public void setIdprimercliente(int idprimercliente) {
        this.idprimercliente = idprimercliente;
    }

    public int getIdultimocliente() {
        return idultimocliente;
    }

    public void setIdultimocliente(int idultimocliente) {
        this.idultimocliente = idultimocliente;
    }

    public int getIdusuarioquecarga() {
        return idusuarioquecarga;
    }

    public void setIdusuarioquecarga(int idusuarioquecarga) {
        this.idusuarioquecarga = idusuarioquecarga;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargascliente != null ? idcargascliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaCargasclientes)) {
            return false;
        }
        AaCargasclientes other = (AaCargasclientes) object;
        if ((this.idcargascliente == null && other.idcargascliente != null) || (this.idcargascliente != null && !this.idcargascliente.equals(other.idcargascliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaCargasclientes[ idcargascliente=" + idcargascliente + " ]";
    }
    
}
