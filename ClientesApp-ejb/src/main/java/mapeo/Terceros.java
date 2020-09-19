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
@Table(name = "terceros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terceros.findAll", query = "SELECT t FROM Terceros t")
    , @NamedQuery(name = "Terceros.findByIdtercero", query = "SELECT t FROM Terceros t WHERE t.idtercero = :idtercero")
    , @NamedQuery(name = "Terceros.findByNit", query = "SELECT t FROM Terceros t WHERE t.nit = :nit")
    , @NamedQuery(name = "Terceros.findByDigito", query = "SELECT t FROM Terceros t WHERE t.digito = :digito")
    , @NamedQuery(name = "Terceros.findByNombres", query = "SELECT t FROM Terceros t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "Terceros.findByNombre2", query = "SELECT t FROM Terceros t WHERE t.nombre2 = :nombre2")
    , @NamedQuery(name = "Terceros.findByApellidos", query = "SELECT t FROM Terceros t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Terceros.findByApellido2", query = "SELECT t FROM Terceros t WHERE t.apellido2 = :apellido2")
    , @NamedQuery(name = "Terceros.findByDireccion", query = "SELECT t FROM Terceros t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Terceros.findByTelefono", query = "SELECT t FROM Terceros t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Terceros.findByTelefono2", query = "SELECT t FROM Terceros t WHERE t.telefono2 = :telefono2")
    , @NamedQuery(name = "Terceros.findByFax", query = "SELECT t FROM Terceros t WHERE t.fax = :fax")
    , @NamedQuery(name = "Terceros.findByEmail", query = "SELECT t FROM Terceros t WHERE t.email = :email")
    , @NamedQuery(name = "Terceros.findByCliente", query = "SELECT t FROM Terceros t WHERE t.cliente = :cliente")
    , @NamedQuery(name = "Terceros.findByProveedor", query = "SELECT t FROM Terceros t WHERE t.proveedor = :proveedor")
    , @NamedQuery(name = "Terceros.findByEmpleado", query = "SELECT t FROM Terceros t WHERE t.empleado = :empleado")
    , @NamedQuery(name = "Terceros.findByOtros", query = "SELECT t FROM Terceros t WHERE t.otros = :otros")
    , @NamedQuery(name = "Terceros.findByManejoica", query = "SELECT t FROM Terceros t WHERE t.manejoica = :manejoica")
    , @NamedQuery(name = "Terceros.findByAutoretenedor", query = "SELECT t FROM Terceros t WHERE t.autoretenedor = :autoretenedor")
    , @NamedQuery(name = "Terceros.findByFechacumple", query = "SELECT t FROM Terceros t WHERE t.fechacumple = :fechacumple")
    , @NamedQuery(name = "Terceros.findByMancond", query = "SELECT t FROM Terceros t WHERE t.mancond = :mancond")
    , @NamedQuery(name = "Terceros.findByIdconcprecio", query = "SELECT t FROM Terceros t WHERE t.idconcprecio = :idconcprecio")
    , @NamedQuery(name = "Terceros.findByAplicaprom", query = "SELECT t FROM Terceros t WHERE t.aplicaprom = :aplicaprom")
    , @NamedQuery(name = "Terceros.findByComentario", query = "SELECT t FROM Terceros t WHERE t.comentario = :comentario")
    , @NamedQuery(name = "Terceros.findByBarcode", query = "SELECT t FROM Terceros t WHERE t.barcode = :barcode")
    , @NamedQuery(name = "Terceros.findByManejacupocred", query = "SELECT t FROM Terceros t WHERE t.manejacupocred = :manejacupocred")
    , @NamedQuery(name = "Terceros.findByCupocred", query = "SELECT t FROM Terceros t WHERE t.cupocred = :cupocred")
    , @NamedQuery(name = "Terceros.findByInactivo", query = "SELECT t FROM Terceros t WHERE t.inactivo = :inactivo")
    , @NamedQuery(name = "Terceros.findByRestringirpagos", query = "SELECT t FROM Terceros t WHERE t.restringirpagos = :restringirpagos")
    , @NamedQuery(name = "Terceros.findByManejasedes", query = "SELECT t FROM Terceros t WHERE t.manejasedes = :manejasedes")
    , @NamedQuery(name = "Terceros.findByRestringirprodcompras", query = "SELECT t FROM Terceros t WHERE t.restringirprodcompras = :restringirprodcompras")
    , @NamedQuery(name = "Terceros.findByTipoprecio", query = "SELECT t FROM Terceros t WHERE t.tipoprecio = :tipoprecio")
    , @NamedQuery(name = "Terceros.findByVersion", query = "SELECT t FROM Terceros t WHERE t.version = :version")
    , @NamedQuery(name = "Terceros.findByUsapuntos", query = "SELECT t FROM Terceros t WHERE t.usapuntos = :usapuntos")
    , @NamedQuery(name = "Terceros.findByBaseretencion", query = "SELECT t FROM Terceros t WHERE t.baseretencion = :baseretencion")
    , @NamedQuery(name = "Terceros.findByPorcentajeretencion", query = "SELECT t FROM Terceros t WHERE t.porcentajeretencion = :porcentajeretencion")})
public class Terceros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtercero")
    private Integer idtercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "digito")
    private int digito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "nombre2")
    private String nombre2;
    @Size(max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 60)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 12)
    @Column(name = "telefono2")
    private String telefono2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @Column(name = "cliente")
    private Integer cliente;
    @Column(name = "proveedor")
    private Integer proveedor;
    @Column(name = "empleado")
    private Integer empleado;
    @Column(name = "otros")
    private Integer otros;
    @Column(name = "manejoica")
    private Integer manejoica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autoretenedor")
    private int autoretenedor;
    @Size(max = 8)
    @Column(name = "fechacumple")
    private String fechacumple;
    @Column(name = "mancond")
    private Short mancond;
    @Column(name = "idconcprecio")
    private Integer idconcprecio;
    @Column(name = "aplicaprom")
    private Short aplicaprom;
    @Size(max = 255)
    @Column(name = "comentario")
    private String comentario;
    @Size(max = 20)
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "manejacupocred")
    private Short manejacupocred;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cupocred")
    private Double cupocred;
    @Column(name = "inactivo")
    private Short inactivo;
    @Column(name = "restringirpagos")
    private Short restringirpagos;
    @Column(name = "manejasedes")
    private Short manejasedes;
    @Column(name = "restringirprodcompras")
    private Short restringirprodcompras;
    @Column(name = "tipoprecio")
    private Short tipoprecio;
    @Column(name = "version")
    private Integer version;
    @Column(name = "usapuntos")
    private Short usapuntos;
    @Column(name = "baseretencion")
    private Double baseretencion;
    @Column(name = "porcentajeretencion")
    private Double porcentajeretencion;

    public Terceros() {
    }

    public Terceros(Integer idtercero) {
        this.idtercero = idtercero;
    }

    public Terceros(Integer idtercero, String nit, int digito, String nombres, int autoretenedor) {
        this.idtercero = idtercero;
        this.nit = nit;
        this.digito = digito;
        this.nombres = nombres;
        this.autoretenedor = autoretenedor;
    }

    public Integer getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(Integer idtercero) {
        this.idtercero = idtercero;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public Integer getOtros() {
        return otros;
    }

    public void setOtros(Integer otros) {
        this.otros = otros;
    }

    public Integer getManejoica() {
        return manejoica;
    }

    public void setManejoica(Integer manejoica) {
        this.manejoica = manejoica;
    }

    public int getAutoretenedor() {
        return autoretenedor;
    }

    public void setAutoretenedor(int autoretenedor) {
        this.autoretenedor = autoretenedor;
    }

    public String getFechacumple() {
        return fechacumple;
    }

    public void setFechacumple(String fechacumple) {
        this.fechacumple = fechacumple;
    }

    public Short getMancond() {
        return mancond;
    }

    public void setMancond(Short mancond) {
        this.mancond = mancond;
    }

    public Integer getIdconcprecio() {
        return idconcprecio;
    }

    public void setIdconcprecio(Integer idconcprecio) {
        this.idconcprecio = idconcprecio;
    }

    public Short getAplicaprom() {
        return aplicaprom;
    }

    public void setAplicaprom(Short aplicaprom) {
        this.aplicaprom = aplicaprom;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Short getManejacupocred() {
        return manejacupocred;
    }

    public void setManejacupocred(Short manejacupocred) {
        this.manejacupocred = manejacupocred;
    }

    public Double getCupocred() {
        return cupocred;
    }

    public void setCupocred(Double cupocred) {
        this.cupocred = cupocred;
    }

    public Short getInactivo() {
        return inactivo;
    }

    public void setInactivo(Short inactivo) {
        this.inactivo = inactivo;
    }

    public Short getRestringirpagos() {
        return restringirpagos;
    }

    public void setRestringirpagos(Short restringirpagos) {
        this.restringirpagos = restringirpagos;
    }

    public Short getManejasedes() {
        return manejasedes;
    }

    public void setManejasedes(Short manejasedes) {
        this.manejasedes = manejasedes;
    }

    public Short getRestringirprodcompras() {
        return restringirprodcompras;
    }

    public void setRestringirprodcompras(Short restringirprodcompras) {
        this.restringirprodcompras = restringirprodcompras;
    }

    public Short getTipoprecio() {
        return tipoprecio;
    }

    public void setTipoprecio(Short tipoprecio) {
        this.tipoprecio = tipoprecio;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Short getUsapuntos() {
        return usapuntos;
    }

    public void setUsapuntos(Short usapuntos) {
        this.usapuntos = usapuntos;
    }

    public Double getBaseretencion() {
        return baseretencion;
    }

    public void setBaseretencion(Double baseretencion) {
        this.baseretencion = baseretencion;
    }

    public Double getPorcentajeretencion() {
        return porcentajeretencion;
    }

    public void setPorcentajeretencion(Double porcentajeretencion) {
        this.porcentajeretencion = porcentajeretencion;
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
        if (!(object instanceof Terceros)) {
            return false;
        }
        Terceros other = (Terceros) object;
        if ((this.idtercero == null && other.idtercero != null) || (this.idtercero != null && !this.idtercero.equals(other.idtercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeo.Terceros[ idtercero=" + idtercero + " ]";
    }
    
}
