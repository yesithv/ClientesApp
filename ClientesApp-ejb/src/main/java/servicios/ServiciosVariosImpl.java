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
import mapeo.AaNivel1;
import mapeo.AaNivel2;
import mapeo.AaNivel3;
import mapeo.AaNivel4;
import mapeo.AaNivel5;
import mapeo.AaNivel6;
import mapeo.Terceros;

/**
 * @Singleton Porque necesito una sola instancia dlel ejb en toda la aplicacion
 * @author YesithV
 */
@Singleton
public class ServiciosVariosImpl implements ServiciosVarios {

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
    public Boolean guardarObjetoCliente(AaClientes objetoCliente) {
        this.guardarObjeto(objetoCliente);

        // Averiguo cual tabla esta disponible para guardar el nuevo cliente
        AaCapacidades capacidadActual = new AaCapacidades();
        List<AaCapacidades> capacidadesList = this.obtenerCapacidades();
        for (AaCapacidades capacidad : capacidadesList) {
            if (capacidad.getNumeroregistros() < capacidad.getMaximacapacidad()) {
                capacidadActual = capacidad;
                break;
            }
        }

        // Busco el padre disponible
        String consulta = "";
        Query qConsulta = null;
        List<AaNivel1> listaNivel1 = null;
        List<AaNivel2> listaNivel2 = null;
        List<AaNivel3> listaNivel3 = null;
        List<AaNivel4> listaNivel4 = null;
        List<AaNivel5> listaNivel5 = null;
        List<AaNivel6> listaNivel6 = null;
        switch (capacidadActual.getIdcapacidad()) {
            case 1:
                consulta = " SELECT N FROM AaNivel1 N order by N.hijos, N.idnivel1 ";
                qConsulta = em.createQuery(consulta, AaNivel1.class);
                listaNivel1 = (List<AaNivel1>) qConsulta.getResultList();
                break;
            case 2:
                consulta = " SELECT N FROM AaNivel2 N order by N.hijos, N.idnivel2 ";
                qConsulta = em.createQuery(consulta, AaNivel2.class);
                listaNivel2 = (List<AaNivel2>) qConsulta.getResultList();
                break;
            case 3:
                consulta = " SELECT N FROM AaNivel3 N order by N.hijos, N.idnivel3 ";
                qConsulta = em.createQuery(consulta, AaNivel3.class);
                listaNivel3 = (List<AaNivel3>) qConsulta.getResultList();
                break;
            case 4:
                consulta = " SELECT N FROM AaNivel4 N order by N.hijos, N.idnivel4 ";
                qConsulta = em.createQuery(consulta, AaNivel4.class);
                listaNivel4 = (List<AaNivel4>) qConsulta.getResultList();
                break;
            case 5:
                consulta = " SELECT N FROM AaNivel5 N order by N.hijos, N.idnivel5 ";
                qConsulta = em.createQuery(consulta, AaNivel5.class);
                listaNivel5 = (List<AaNivel5>) qConsulta.getResultList();
                break;
            case 6:
                consulta = " SELECT N FROM AaNivel6 N order by N.hijos, N.idnivel6 ";
                qConsulta = em.createQuery(consulta, AaNivel6.class);
                listaNivel6 = (List<AaNivel6>) qConsulta.getResultList();
                break;
        }

        return Boolean.TRUE;
    }

    private List<AaCapacidades> obtenerCapacidades() {
        String sConsulta = " SELECT C FROM AaCapacidades C ORDER BY C.idcapacidad ASC";
        Query qConsulta = em.createQuery(sConsulta, AaCapacidades.class);
        return (List<AaCapacidades>) qConsulta.getResultList();
    }

}
