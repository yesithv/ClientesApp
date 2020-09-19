/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Remote;
import mapeo.AaCargasclientes;
import mapeo.Terceros;

/**
 *
 * @author YesithV
 */
@Remote
public interface ServiciosCarga {

    AaCargasclientes buscarUltimaCarga();

    List<Terceros> tercerosList(Integer ultimoIdCargado);

    void cargarTercerosClientesApp();

}
