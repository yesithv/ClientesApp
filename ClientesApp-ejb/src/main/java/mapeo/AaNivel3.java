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
@Table(name = "aa_nivel3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaNivel3.findAll", query = "SELECT a FROM AaNivel3 a")
    , @NamedQuery(name = "AaNivel3.findByIdnivel3", query = "SELECT a FROM AaNivel3 a WHERE a.idnivel3 = :idnivel3")
    , @NamedQuery(name = "AaNivel3.findByIdpunto", query = "SELECT a FROM AaNivel3 a WHERE a.idpunto = :idpunto")
    , @NamedQuery(name = "AaNivel3.findByIdciudad", query = "SELECT a FROM AaNivel3 a WHERE a.idciudad = :idciudad")
    , @NamedQuery(name = "AaNivel3.findByHijos", query = "SELECT a FROM AaNivel3 a WHERE a.hijos = :hijos")})
public class AaNivel3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel3")
    private Integer idnivel3;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidnivel3", fetch = FetchType.LAZY)
    private List<AaNivel4> aaNivel4List;
    @JoinColumn(name = "fkcliente", referencedColumnName = "idtercero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaClientes fkcliente;
    @JoinColumn(name = "fkidnivel2", referencedColumnName = "idnivel2")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaNivel2 fkidnivel2;

    public AaNivel3() {
    }

    public AaNivel3(Integer idnivel3) {
        this.idnivel3 = idnivel3;
    }

    public AaNivel3(Integer idnivel3, int idpunto, int idciudad, int hijos) {
        this.idnivel3 = idnivel3;
        this.idpunto = idpunto;
        this.idciudad = idciudad;
        this.hijos = hijos;
    }

    public Integer getIdnivel3() {
        return idnivel3;
    }

    public void setIdnivel3(Integer idnivel3) {
        this.idnivel3 = idnivel3;
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
    public List<AaNivel4> getAaNivel4List() {
        return aaNivel4List;
    }

    public void setAaNivel4List(List<AaNivel4> aaNivel4List) {
        this.aaNivel4List = aaNivel4List;
    }

    public AaClientes getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(AaClientes fkcliente) {
        this.fkcliente = fkcliente;
    }

    public AaNivel2 getFkidnivel2() {
        return fkidnivel2;
    }

    public void setFkidnivel2(AaNivel2 fkidnivel2) {
        this.fkidnivel2 = fkidnivel2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel3 != null ? idnivel3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaNivel3)) {
            return false;
        }
        AaNivel3 other = (AaNivel3) object;
        if ((this.idnivel3 == null && other.idnivel3 != null) || (this.idnivel3 != null && !this.idnivel3.equals(other.idnivel3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaNivel3[ idnivel3=" + idnivel3 + " ]";
    }
    
}
