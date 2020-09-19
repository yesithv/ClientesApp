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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaClientes.findAll", query = "SELECT a FROM AaClientes a")
    , @NamedQuery(name = "AaClientes.findByIdtercero", query = "SELECT a FROM AaClientes a WHERE a.idtercero = :idtercero")
    , @NamedQuery(name = "AaClientes.findByNombresyapellidos", query = "SELECT a FROM AaClientes a WHERE a.nombresyapellidos = :nombresyapellidos")
    , @NamedQuery(name = "AaClientes.findByNumerodocumento", query = "SELECT a FROM AaClientes a WHERE a.numerodocumento = :numerodocumento")
    , @NamedQuery(name = "AaClientes.findByActivo", query = "SELECT a FROM AaClientes a WHERE a.activo = :activo")})
public class AaClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtercero")
    private Integer idtercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombresyapellidos")
    private String nombresyapellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numerodocumento")
    private String numerodocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente", fetch = FetchType.LAZY)
    private List<AaNivel6> aaNivel6List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente", fetch = FetchType.LAZY)
    private List<AaNivel5> aaNivel5List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkprimercliente", fetch = FetchType.LAZY)
    private List<AaCargasclientes> aaCargasclientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkultimocliente", fetch = FetchType.LAZY)
    private List<AaCargasclientes> aaCargasclientesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente", fetch = FetchType.LAZY)
    private List<AaNivel4> aaNivel4List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente", fetch = FetchType.LAZY)
    private List<AaNivel3> aaNivel3List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente", fetch = FetchType.LAZY)
    private List<AaNivel2> aaNivel2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente", fetch = FetchType.LAZY)
    private List<AaNivel1> aaNivel1List;

    public AaClientes() {
    }

    public AaClientes(Integer idtercero) {
        this.idtercero = idtercero;
    }

    public AaClientes(Integer idtercero, String nombresyapellidos, String numerodocumento, short activo) {
        this.idtercero = idtercero;
        this.nombresyapellidos = nombresyapellidos;
        this.numerodocumento = numerodocumento;
        this.activo = activo;
    }

    public Integer getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(Integer idtercero) {
        this.idtercero = idtercero;
    }

    public String getNombresyapellidos() {
        return nombresyapellidos;
    }

    public void setNombresyapellidos(String nombresyapellidos) {
        this.nombresyapellidos = nombresyapellidos;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<AaNivel6> getAaNivel6List() {
        return aaNivel6List;
    }

    public void setAaNivel6List(List<AaNivel6> aaNivel6List) {
        this.aaNivel6List = aaNivel6List;
    }

    @XmlTransient
    public List<AaNivel5> getAaNivel5List() {
        return aaNivel5List;
    }

    public void setAaNivel5List(List<AaNivel5> aaNivel5List) {
        this.aaNivel5List = aaNivel5List;
    }

    @XmlTransient
    public List<AaCargasclientes> getAaCargasclientesList() {
        return aaCargasclientesList;
    }

    public void setAaCargasclientesList(List<AaCargasclientes> aaCargasclientesList) {
        this.aaCargasclientesList = aaCargasclientesList;
    }

    @XmlTransient
    public List<AaCargasclientes> getAaCargasclientesList1() {
        return aaCargasclientesList1;
    }

    public void setAaCargasclientesList1(List<AaCargasclientes> aaCargasclientesList1) {
        this.aaCargasclientesList1 = aaCargasclientesList1;
    }

    @XmlTransient
    public List<AaNivel4> getAaNivel4List() {
        return aaNivel4List;
    }

    public void setAaNivel4List(List<AaNivel4> aaNivel4List) {
        this.aaNivel4List = aaNivel4List;
    }

    @XmlTransient
    public List<AaNivel3> getAaNivel3List() {
        return aaNivel3List;
    }

    public void setAaNivel3List(List<AaNivel3> aaNivel3List) {
        this.aaNivel3List = aaNivel3List;
    }

    @XmlTransient
    public List<AaNivel2> getAaNivel2List() {
        return aaNivel2List;
    }

    public void setAaNivel2List(List<AaNivel2> aaNivel2List) {
        this.aaNivel2List = aaNivel2List;
    }

    @XmlTransient
    public List<AaNivel1> getAaNivel1List() {
        return aaNivel1List;
    }

    public void setAaNivel1List(List<AaNivel1> aaNivel1List) {
        this.aaNivel1List = aaNivel1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtercero != null ? idtercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaClientes)) {
            return false;
        }
        AaClientes other = (AaClientes) object;
        if ((this.idtercero == null && other.idtercero != null) || (this.idtercero != null && !this.idtercero.equals(other.idtercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaClientes[ idtercero=" + idtercero + " ]";
    }
    
}
