/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mapeo.AaUsuario;

/**
 * @Stateful Porque necesitamos que sea una nueva instancia cada vez que se
 * refresca la pagina
 * @author YesithV
 */
@Stateful(name = "SeerviciosLoginImpl")
public class ServiciosLoginImpl implements ServiciosLogin {

    @PersistenceContext
    private EntityManager em;

    @Override
    public AaUsuario validarLogin(AaUsuario usuarioValidar) {
        AaUsuario personaRetornar;
        String consulta = "  SELECT a FROM AaUsuario a WHERE a.usuario = :pUsuario AND a.password = :pPassword AND a.activo = 1 ";
        Query qConsulta = em.createQuery(consulta, AaUsuario.class);
        qConsulta.setParameter("pUsuario", usuarioValidar.getUsuario());
        qConsulta.setParameter("pPassword", usuarioValidar.getPassword());
        if (qConsulta.getResultList().isEmpty()) {
            personaRetornar = null;
        } else {
            personaRetornar = (AaUsuario) qConsulta.getSingleResult();
        }
        return personaRetornar;
    }

}
