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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aa_nivel4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaNivel4.findAll", query = "SELECT a FROM AaNivel4 a")
    , @NamedQuery(name = "AaNivel4.findByIdnivel4", query = "SELECT a FROM AaNivel4 a WHERE a.idnivel4 = :idnivel4")
    , @NamedQuery(name = "AaNivel4.findByIdcliente", query = "SELECT a FROM AaNivel4 a WHERE a.idcliente = :idcliente")
    , @NamedQuery(name = "AaNivel4.findByIdpunto", query = "SELECT a FROM AaNivel4 a WHERE a.idpunto = :idpunto")
    , @NamedQuery(name = "AaNivel4.findByIdcuidad", query = "SELECT a FROM AaNivel4 a WHERE a.idcuidad = :idcuidad")
    , @NamedQuery(name = "AaNivel4.findByHijos", query = "SELECT a FROM AaNivel4 a WHERE a.hijos = :hijos")})
public class AaNivel4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel4")
    private Integer idnivel4;
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
    @Column(name = "idcuidad")
    private int idcuidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hijos")
    private int hijos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidnivel4", fetch = FetchType.LAZY)
    private List<AaNivel5> aaNivel5List;
    @JoinColumn(name = "fkcliente", referencedColumnName = "idtercero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaClientes fkcliente;
    @JoinColumn(name = "fkidnivel3", referencedColumnName = "idnivel3")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaNivel3 fkidnivel3;

    public AaNivel4() {
    }

    public AaNivel4(Integer idnivel4) {
        this.idnivel4 = idnivel4;
    }

    public AaNivel4(Integer idnivel4, int idcliente, int idpunto, int idcuidad, int hijos) {
        this.idnivel4 = idnivel4;
        this.idcliente = idcliente;
        this.idpunto = idpunto;
        this.idcuidad = idcuidad;
        this.hijos = hijos;
    }

    public Integer getIdnivel4() {
        return idnivel4;
    }

    public void setIdnivel4(Integer idnivel4) {
        this.idnivel4 = idnivel4;
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

    public int getIdcuidad() {
        return idcuidad;
    }

    public void setIdcuidad(int idcuidad) {
        this.idcuidad = idcuidad;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    @XmlTransient
    public List<AaNivel5> getAaNivel5List() {
        return aaNivel5List;
    }

    public void setAaNivel5List(List<AaNivel5> aaNivel5List) {
        this.aaNivel5List = aaNivel5List;
    }

    public AaClientes getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(AaClientes fkcliente) {
        this.fkcliente = fkcliente;
    }

    public AaNivel3 getFkidnivel3() {
        return fkidnivel3;
    }

    public void setFkidnivel3(AaNivel3 fkidnivel3) {
        this.fkidnivel3 = fkidnivel3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel4 != null ? idnivel4.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaNivel4)) {
            return false;
        }
        AaNivel4 other = (AaNivel4) object;
        if ((this.idnivel4 == null && other.idnivel4 != null) || (this.idnivel4 != null && !this.idnivel4.equals(other.idnivel4))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaNivel4[ idnivel4=" + idnivel4 + " ]";
    }
    
}
