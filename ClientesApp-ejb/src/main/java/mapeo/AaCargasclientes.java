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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Size(max = 60)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "fkprimercliente", referencedColumnName = "idtercero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaClientes fkprimercliente;
    @JoinColumn(name = "fkultimocliente", referencedColumnName = "idtercero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaClientes fkultimocliente;
    @JoinColumn(name = "fkusuariocarga", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaUsuario fkusuariocarga;

    public AaCargasclientes() {
    }

    public AaCargasclientes(Integer idcargascliente) {
        this.idcargascliente = idcargascliente;
    }

    public AaCargasclientes(Integer idcargascliente, Date fechacarga) {
        this.idcargascliente = idcargascliente;
        this.fechacarga = fechacarga;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public AaClientes getFkprimercliente() {
        return fkprimercliente;
    }

    public void setFkprimercliente(AaClientes fkprimercliente) {
        this.fkprimercliente = fkprimercliente;
    }

    public AaClientes getFkultimocliente() {
        return fkultimocliente;
    }

    public void setFkultimocliente(AaClientes fkultimocliente) {
        this.fkultimocliente = fkultimocliente;
    }

    public AaUsuario getFkusuariocarga() {
        return fkusuariocarga;
    }

    public void setFkusuariocarga(AaUsuario fkusuariocarga) {
        this.fkusuariocarga = fkusuariocarga;
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
