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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaUsuario.findAll", query = "SELECT a FROM AaUsuario a")
    , @NamedQuery(name = "AaUsuario.findByIdusuario", query = "SELECT a FROM AaUsuario a WHERE a.idusuario = :idusuario")
    , @NamedQuery(name = "AaUsuario.findByDocumento", query = "SELECT a FROM AaUsuario a WHERE a.documento = :documento")
    , @NamedQuery(name = "AaUsuario.findByPassword", query = "SELECT a FROM AaUsuario a WHERE a.password = :password")
    , @NamedQuery(name = "AaUsuario.findByNombre", query = "SELECT a FROM AaUsuario a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AaUsuario.findByActivo", query = "SELECT a FROM AaUsuario a WHERE a.activo = :activo")})
public class AaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkusuariocarga", fetch = FetchType.LAZY)
    private List<AaCargasclientes> aaCargasclientesList;

    public AaUsuario() {
    }

    public AaUsuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public AaUsuario(Integer idusuario, String documento, String password, String nombre, short activo) {
        this.idusuario = idusuario;
        this.documento = documento;
        this.password = password;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<AaCargasclientes> getAaCargasclientesList() {
        return aaCargasclientesList;
    }

    public void setAaCargasclientesList(List<AaCargasclientes> aaCargasclientesList) {
        this.aaCargasclientesList = aaCargasclientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaUsuario)) {
            return false;
        }
        AaUsuario other = (AaUsuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaUsuario[ idusuario=" + idusuario + " ]";
    }
    
}
