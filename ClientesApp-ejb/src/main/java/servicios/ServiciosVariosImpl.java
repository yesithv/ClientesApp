/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
