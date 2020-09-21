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

    /**
     * Metodo encargado de buscar la ultima carga realizada
     *
     * @return Objeto con los datos de la ultima carga
     */
    AaCargasclientes buscarUltimaCarga();

    /**
     * Buscar en la tabla terceros los que tienen tipo de cliente = 1
     *
     * @param ultimoIdCargado ultimo cliente cargado
     * @return Listado de terceros
     */
    List<Terceros> tercerosList(Integer ultimoIdCargado);

}
