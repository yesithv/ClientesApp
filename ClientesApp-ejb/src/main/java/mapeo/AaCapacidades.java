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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YesithV
 */
@Entity
@Table(name = "aa_capacidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AaCapacidades.findAll", query = "SELECT a FROM AaCapacidades a")
    , @NamedQuery(name = "AaCapacidades.findByIdcapacidad", query = "SELECT a FROM AaCapacidades a WHERE a.idcapacidad = :idcapacidad")
    , @NamedQuery(name = "AaCapacidades.findByNombretabla", query = "SELECT a FROM AaCapacidades a WHERE a.nombretabla = :nombretabla")
    , @NamedQuery(name = "AaCapacidades.findByNumeroregistros", query = "SELECT a FROM AaCapacidades a WHERE a.numeroregistros = :numeroregistros")
    , @NamedQuery(name = "AaCapacidades.findByMaximacapacidad", query = "SELECT a FROM AaCapacidades a WHERE a.maximacapacidad = :maximacapacidad")})
public class AaCapacidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcapacidad")
    private Integer idcapacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombretabla")
    private String nombretabla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroregistros")
    private int numeroregistros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maximacapacidad")
    private int maximacapacidad;

    public AaCapacidades() {
    }

    public AaCapacidades(Integer idcapacidad) {
        this.idcapacidad = idcapacidad;
    }

    public AaCapacidades(Integer idcapacidad, String nombretabla, int numeroregistros, int maximacapacidad) {
        this.idcapacidad = idcapacidad;
        this.nombretabla = nombretabla;
        this.numeroregistros = numeroregistros;
        this.maximacapacidad = maximacapacidad;
    }

    public Integer getIdcapacidad() {
        return idcapacidad;
    }

    public void setIdcapacidad(Integer idcapacidad) {
        this.idcapacidad = idcapacidad;
    }

    public String getNombretabla() {
        return nombretabla;
    }

    public void setNombretabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    public int getNumeroregistros() {
        return numeroregistros;
    }

    public void setNumeroregistros(int numeroregistros) {
        this.numeroregistros = numeroregistros;
    }

    public int getMaximacapacidad() {
        return maximacapacidad;
    }

    public void setMaximacapacidad(int maximacapacidad) {
        this.maximacapacidad = maximacapacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcapacidad != null ? idcapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AaCapacidades)) {
            return false;
        }
        AaCapacidades other = (AaCapacidades) object;
        if ((this.idcapacidad == null && other.idcapacidad != null) || (this.idcapacidad != null && !this.idcapacidad.equals(other.idcapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.AaCapacidades[ idcapacidad=" + idcapacidad + " ]";
    }
    
}
