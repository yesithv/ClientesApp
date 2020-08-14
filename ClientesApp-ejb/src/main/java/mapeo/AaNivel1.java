/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_nivel1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaNivel1.findAll", query = "SELECT a FROM AaNivel1 a")
    , @NamedQuery(name = "AaNivel1.findByIdnivel1", query = "SELECT a FROM AaNivel1 a WHERE a.idnivel1 = :idnivel1")
    , @NamedQuery(name = "AaNivel1.findByIdcliente", query = "SELECT a FROM AaNivel1 a WHERE a.idcliente = :idcliente")
    , @NamedQuery(name = "AaNivel1.findByIdpunto", query = "SELECT a FROM AaNivel1 a WHERE a.idpunto = :idpunto")
    , @NamedQuery(name = "AaNivel1.findByIdciudad", query = "SELECT a FROM AaNivel1 a WHERE a.idciudad = :idciudad")
    , @NamedQuery(name = "AaNivel1.findByHijos", query = "SELECT a FROM AaNivel1 a WHERE a.hijos = :hijos")})
public class AaNivel1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel1")
    private Integer idnivel1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcliente")
    private int idcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpunto")
    private int idpunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idciudad")
    private int idciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hijos")
    private int hijos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidnivel1", fetch = FetchType.LAZY)
    private List<AaNivel2> aaNivel2List;

    public AaNivel1() {
    }

    public AaNivel1(Integer idnivel1) {
        this.idnivel1 = idnivel1;
    }

    public AaNivel1(Integer idnivel1, int idcliente, int idpunto, int idciudad, int hijos) {
        this.idnivel1 = idnivel1;
        this.idcliente = idcliente;
        this.idpunto = idpunto;
        this.idciudad = idciudad;
        this.hijos = hijos;
    }

    public Integer getIdnivel1() {
        return idnivel1;
    }

    public void setIdnivel1(Integer idnivel1) {
        this.idnivel1 = idnivel1;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdpunto() {
        return idpunto;
    }

    public void setIdpunto(int idpunto) {
        this.idpunto = idpunto;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    @XmlTransient
    public List<AaNivel2> getAaNivel2List() {
        return aaNivel2List;
    }

    public void setAaNivel2List(List<AaNivel2> aaNivel2List) {
        this.aaNivel2List = aaNivel2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel1 != null ? idnivel1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaNivel1)) {
            return false;
        }
        AaNivel1 other = (AaNivel1) object;
        if ((this.idnivel1 == null && other.idnivel1 != null) || (this.idnivel1 != null && !this.idnivel1.equals(other.idnivel1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaNivel1[ idnivel1=" + idnivel1 + " ]";
    }
    
}
