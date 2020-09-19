/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mapeo.AaCargasclientes;
import mapeo.Terceros;

/**
 *
 * @author YesithV
 */
@Stateful(name = "ServiciosCargaImpl")
public class ServiciosCargaImpl implements ServiciosCarga {

    @PersistenceContext
    private EntityManager em;

    @Override
    public AaCargasclientes buscarUltimaCarga() {
        AaCargasclientes retornoCargas = new AaCargasclientes();
        String consulta = "  SELECT a FROM AaCargasclientes a ORDER BY a.idcargascliente DESC ";
        Query qConsulta = em.createQuery(consulta, AaCargasclientes.class);
        List<AaCargasclientes> resultadoLista = qConsulta.getResultList();
        if (resultadoLista.isEmpty()) {
            retornoCargas = null;
        } else {
            for (AaCargasclientes aaCargasclientes : resultadoLista) {
                // Cargo los objetos padre
                aaCargasclientes.getFkprimercliente();
                aaCargasclientes.getFkultimocliente();
                aaCargasclientes.getFkusuariocarga();
                retornoCargas = aaCargasclientes;
                // Sólo me traigo los datos de la ultima carga
                break;
            }
        }
        return retornoCargas;
    }

    @Override
    public List<Terceros> tercerosList(Integer ultimoIdCargado) {
        String consulta = " SELECT t FROM Terceros t WHERE t.cliente = :pCliente AND t.idtercero > :pIdTercero ";
        Query qConsulta = em.createQuery(consulta, Terceros.class);
        qConsulta.setParameter("pCliente", 1);
        qConsulta.setParameter("pIdTercero", ultimoIdCargado);
        return (List<Terceros>) qConsulta.getResultList();
    }

    @Override
    public void cargarTercerosClientesApp() {

    }
}
