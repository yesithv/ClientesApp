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
@Table(name = "aa_nivel2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaNivel2.findAll", query = "SELECT a FROM AaNivel2 a")
    , @NamedQuery(name = "AaNivel2.findByIdnivel2", query = "SELECT a FROM AaNivel2 a WHERE a.idnivel2 = :idnivel2")
    , @NamedQuery(name = "AaNivel2.findByIdcliente", query = "SELECT a FROM AaNivel2 a WHERE a.idcliente = :idcliente")
    , @NamedQuery(name = "AaNivel2.findByIdpunto", query = "SELECT a FROM AaNivel2 a WHERE a.idpunto = :idpunto")
    , @NamedQuery(name = "AaNivel2.findByIdciudad", query = "SELECT a FROM AaNivel2 a WHERE a.idciudad = :idciudad")
    , @NamedQuery(name = "AaNivel2.findByHijos", query = "SELECT a FROM AaNivel2 a WHERE a.hijos = :hijos")})
public class AaNivel2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel2")
    private Integer idnivel2;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidnivel2", fetch = FetchType.LAZY)
    private List<AaNivel3> aaNivel3List;
    @JoinColumn(name = "fkidnivel1", referencedColumnName = "idnivel1")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaNivel1 fkidnivel1;

    public AaNivel2() {
    }

    public AaNivel2(Integer idnivel2) {
        this.idnivel2 = idnivel2;
    }

    public AaNivel2(Integer idnivel2, int idcliente, int idpunto, int idciudad, int hijos) {
        this.idnivel2 = idnivel2;
        this.idcliente = idcliente;
        this.idpunto = idpunto;
        this.idciudad = idciudad;
        this.hijos = hijos;
    }

    public Integer getIdnivel2() {
        return idnivel2;
    }

    public void setIdnivel2(Integer idnivel2) {
        this.idnivel2 = idnivel2;
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
    public List<AaNivel3> getAaNivel3List() {
        return aaNivel3List;
    }

    public void setAaNivel3List(List<AaNivel3> aaNivel3List) {
        this.aaNivel3List = aaNivel3List;
    }

    public AaNivel1 getFkidnivel1() {
        return fkidnivel1;
    }

    public void setFkidnivel1(AaNivel1 fkidnivel1) {
        this.fkidnivel1 = fkidnivel1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel2 != null ? idnivel2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaNivel2)) {
            return false;
        }
        AaNivel2 other = (AaNivel2) object;
        if ((this.idnivel2 == null && other.idnivel2 != null) || (this.idnivel2 != null && !this.idnivel2.equals(other.idnivel2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaNivel2[ idnivel2=" + idnivel2 + " ]";
    }
    
}
