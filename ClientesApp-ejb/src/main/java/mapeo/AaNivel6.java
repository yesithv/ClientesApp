/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_nivel6")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaNivel6.findAll", query = "SELECT a FROM AaNivel6 a")
    , @NamedQuery(name = "AaNivel6.findByIdnivel6", query = "SELECT a FROM AaNivel6 a WHERE a.idnivel6 = :idnivel6")
    , @NamedQuery(name = "AaNivel6.findByIdpunto", query = "SELECT a FROM AaNivel6 a WHERE a.idpunto = :idpunto")
    , @NamedQuery(name = "AaNivel6.findByIdcuidad", query = "SELECT a FROM AaNivel6 a WHERE a.idcuidad = :idcuidad")
    , @NamedQuery(name = "AaNivel6.findByHijos", query = "SELECT a FROM AaNivel6 a WHERE a.hijos = :hijos")})
public class AaNivel6 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel6")
    private Integer idnivel6;
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
    @JoinColumn(name = "fkcliente", referencedColumnName = "idtercero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaClientes fkcliente;
    @JoinColumn(name = "fkidnivel5", referencedColumnName = "idnivel5")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AaNivel5 fkidnivel5;

    public AaNivel6() {
    }

    public AaNivel6(Integer idnivel6) {
        this.idnivel6 = idnivel6;
    }

    public AaNivel6(Integer idnivel6, int idpunto, int idcuidad, int hijos) {
        this.idnivel6 = idnivel6;
        this.idpunto = idpunto;
        this.idcuidad = idcuidad;
        this.hijos = hijos;
    }

    public Integer getIdnivel6() {
        return idnivel6;
    }

    public void setIdnivel6(Integer idnivel6) {
        this.idnivel6 = idnivel6;
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

    public AaClientes getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(AaClientes fkcliente) {
        this.fkcliente = fkcliente;
    }

    public AaNivel5 getFkidnivel5() {
        return fkidnivel5;
    }

    public void setFkidnivel5(AaNivel5 fkidnivel5) {
        this.fkidnivel5 = fkidnivel5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel6 != null ? idnivel6.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaNivel6)) {
            return false;
        }
        AaNivel6 other = (AaNivel6) object;
        if ((this.idnivel6 == null && other.idnivel6 != null) || (this.idnivel6 != null && !this.idnivel6.equals(other.idnivel6))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaNivel6[ idnivel6=" + idnivel6 + " ]";
    }
    
}
