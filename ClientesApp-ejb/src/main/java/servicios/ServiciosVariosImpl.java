/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mapeo.AaCapacidades;
import mapeo.AaClientes;
import mapeo.AaConfiguraciones;
import mapeo.AaNivel1;
import mapeo.AaNivel2;
import mapeo.AaNivel3;
import mapeo.AaNivel4;
import mapeo.AaNivel5;
import mapeo.AaNivel6;

/**
 * @Singleton Porque necesito una sola instancia dlel ejb en toda la aplicacion
 * @author YesithV
 */
@Singleton
public class ServiciosVariosImpl implements ServiciosVarios {

    private String sConsulta = "";
    private Query qConsulta = null;
    private Integer idPunto = 1;
    private Integer idCiudad = 1;
    private Integer numeroHijos = 6;

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public Boolean guardarObjeto(Object objetoGuardar) {
        em.persist(objetoGuardar);
        return Boolean.TRUE;
    }

    @Override
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public Boolean actualizarObjeto(Object objetoActualizar) {
        em.merge(objetoActualizar);
        return Boolean.TRUE;
    }

    @Override
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public Boolean eliminarObjeto(Object objetoEliminar) {
        em.remove(objetoEliminar);
        return Boolean.TRUE;
    }

    @Override
    public Boolean guardarObjetoCliente(AaClientes nuevoClienteGuardar) {
        // Primero guardo el cliente en la tabla de clientes 
        this.guardarObjeto(nuevoClienteGuardar);

        // Averiguo cual tabla esta disponible para guardar el nuevo cliente en el nivel que le corresponde 
        AaCapacidades capacidadActual = this.obtenerTablaConCapacidad();

        // Averiguo la configuracion actual para saber el numero de hijos
        // AaConfiguraciones configuracionActual = this.obtenerConfiguracionActual();
       
        // el idCapacidad es el nivel de la tabla disponible donde se va a guardar el nuevo cliente  
        switch (capacidadActual.getIdcapacidad()) {
            case 1:
                this.guardarEnElNivel1(nuevoClienteGuardar);
                break;
            case 2:
                this.guardarEnElNivel2(nuevoClienteGuardar);
                break;
            case 3:
                this.guardarEnElNivel3(nuevoClienteGuardar);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }

        // Actualizo la nueva capacidad de la tabla
        capacidadActual.setNumeroregistros(capacidadActual.getNumeroregistros() + 1);
        this.actualizarObjeto(capacidadActual);

        return Boolean.TRUE;
    }

    /**
     * Arma el objeto a guardar en el nivel 1
     *
     * @param nuevoClienteGuardar
     */
    private void guardarEnElNivel1(AaClientes nuevoClienteGuardar) {
        // El primer nivel no tiene padres, por esto no se consulta en la tabla "Nivel0"
        // Armo el nuevo cliente a guardar en el nivel 1
        AaNivel1 nuevoClienteNivel1 = new AaNivel1(null, idPunto, idCiudad, 0);
        nuevoClienteNivel1.setFkcliente(nuevoClienteGuardar);
        this.guardarObjeto(nuevoClienteNivel1);
    }

    /**
     * Busca el padre en el nivel 1, luego arma el nivel 2 y lo guarda; y
     * finalmente actualiza el número de hijos del padre
     *
     * @param nuevoClienteGuardar
     */
    private void guardarEnElNivel2(AaClientes nuevoClienteGuardar) {
        // Busco el padre del nuevo cliente en el Nivel 1: Aquel que tenga menos hijos
        sConsulta = " SELECT N FROM AaNivel1 N  WHERE N.hijos < :pHijos order by N.hijos ";
        qConsulta = em.createQuery(sConsulta, AaNivel1.class);
        qConsulta.setMaxResults(1);
        qConsulta.setParameter("pHijos", numeroHijos);
        AaNivel1 padreNivel1 = (AaNivel1) qConsulta.getSingleResult();

        // Armo la referencia del nuevo cliente a guardar en el nivel 2
        AaNivel2 nuevoCLienteNivel2 = new AaNivel2(null, idPunto, idCiudad, 0);
        nuevoCLienteNivel2.setFkcliente(nuevoClienteGuardar);
        nuevoCLienteNivel2.setFkidnivel1(padreNivel1);
        this.guardarObjeto(nuevoCLienteNivel2);

        // Actualizo el numero de hijos en el padre
        padreNivel1.setHijos(padreNivel1.getHijos() + 1);
        this.actualizarObjeto(padreNivel1);
    }

    /**
     * Busca el padre en el nivel2, luego arma el nivel 3 y lo guarda; y
     * finalmente actualiza el número de hijos del padre
     *
     * @param nuevoClienteGuardar
     */
    private void guardarEnElNivel3( AaClientes nuevoClienteGuardar) {
        // Busco el padre del nuevo cliente en el Nivel 2: Aquel que tenga menos hijos
        sConsulta = " SELECT N FROM AaNivel2 N  WHERE N.hijos < :pHijos order by N.hijos ";
        qConsulta = em.createQuery(sConsulta, AaNivel2.class);
        qConsulta.setMaxResults(1);
        qConsulta.setParameter("pHijos", numeroHijos);
        AaNivel2 padreNivel2 = (AaNivel2) qConsulta.getSingleResult();

        // Armo la referencia del nuevo cliente a guardar en el nivel 3
        AaNivel3 nuevoCLienteNivel3 = new AaNivel3(null, idPunto, idCiudad, 0);
        nuevoCLienteNivel3.setFkcliente(nuevoClienteGuardar);
        nuevoCLienteNivel3.setFkidnivel2(padreNivel2);
        this.guardarObjeto(nuevoCLienteNivel3);

        // Actualizo el numero de hijos en el padre
        padreNivel2.setHijos(padreNivel2.getHijos() + 1);
        this.actualizarObjeto(padreNivel2);
    }

    /**
     * Busca en la tabla capacidades el registro que indica en cuál tabla hay
     * capacidad para insertar el nuevo cliente
     *
     * @return objeto con la capacidad actual disponible
     */
    private AaCapacidades obtenerTablaConCapacidad() {
        sConsulta = " SELECT C FROM AaCapacidades C ORDER BY C.idcapacidad ";
        qConsulta = em.createQuery(sConsulta, AaCapacidades.class);
        List<AaCapacidades> todasLasCapacidades = qConsulta.getResultList();
        for (AaCapacidades capacidadRevisar : todasLasCapacidades) {
            if (capacidadRevisar.getNumeroregistros() < capacidadRevisar.getMaximacapacidad()) {
                return capacidadRevisar;
            }

        }
        return null;
    }

    /**
     * Busca en la tabla configuracion actual el registro activo que indica la
     * configuracion actual del sistema
     *
     * @return objeto con la configuracion actual del sistema
     */
    private AaConfiguraciones obtenerConfiguracionActual() {
        sConsulta = " SELECT C FROM AaConfiguraciones C WHERE C.activa = 1";
        qConsulta = em.createQuery(sConsulta, AaConfiguraciones.class);
        return (AaConfiguraciones) qConsulta.getSingleResult();
    }

}
