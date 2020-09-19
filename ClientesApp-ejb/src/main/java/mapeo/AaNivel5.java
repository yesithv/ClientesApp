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
@Table(name = "aa_nivel5")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaNivel5.findAll", query = "SELECT a FROM AaNivel5 a")
    , @NamedQuery(name = "AaNivel5.findByIdnivel5", query = "SELECT a FROM AaNivel5 a WHERE a.idnivel5 = :idnivel5")
    , @NamedQuery(name = "AaNivel5.findByIdpunto", query = "SELECT a FROM AaNivel5 a WHERE a.idpunto = :idpunto")
    , @NamedQuery(name = "AaNivel5.findByIdciudad", query = "SELECT a FROM AaNivel5 a WHERE a.idciudad = :idciudad")
    , @NamedQuery(name = "AaNivel5.findByHijos", query = "SELECT a FROM AaNivel5 a WHERE a.hijos = :hijos")})
public class AaNivel5 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel5")
    private Integer idnivel5;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidnivel5", fetch = FetchType.LAZY)
    private List<AaNivel6> aaNivel6List;
    @JoinColumn(name = "fkcliente", referencedColumnName = "idtercero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaClientes fkcliente;
    @JoinColumn(name = "fkidnivel4", referencedColumnName = "idnivel4")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaNivel4 fkidnivel4;

    public AaNivel5() {
    }

    public AaNivel5(Integer idnivel5) {
        this.idnivel5 = idnivel5;
    }

    public AaNivel5(Integer idnivel5, int idpunto, int idciudad, int hijos) {
        this.idnivel5 = idnivel5;
        this.idpunto = idpunto;
        this.idciudad = idciudad;
        this.hijos = hijos;
    }

    public Integer getIdnivel5() {
        return idnivel5;
    }

    public void setIdnivel5(Integer idnivel5) {
        this.idnivel5 = idnivel5;
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
    public List<AaNivel6> getAaNivel6List() {
        return aaNivel6List;
    }

    public void setAaNivel6List(List<AaNivel6> aaNivel6List) {
        this.aaNivel6List = aaNivel6List;
    }

    public AaClientes getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(AaClientes fkcliente) {
        this.fkcliente = fkcliente;
    }

    public AaNivel4 getFkidnivel4() {
        return fkidnivel4;
    }

    public void setFkidnivel4(AaNivel4 fkidnivel4) {
        this.fkidnivel4 = fkidnivel4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel5 != null ? idnivel5.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaNivel5)) {
            return false;
        }
        AaNivel5 other = (AaNivel5) object;
        if ((this.idnivel5 == null && other.idnivel5 != null) || (this.idnivel5 != null && !this.idnivel5.equals(other.idnivel5))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaNivel5[ idnivel5=" + idnivel5 + " ]";
    }
    
}
