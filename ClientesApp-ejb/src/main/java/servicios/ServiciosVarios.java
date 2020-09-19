/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ejb.Remote;
//import mapeo.Detallelista;

/**
 *
 * @author YesithV
 */
@Remote
public interface ServiciosVarios {

    /**
     * Servicio encargado de guardar una nueva persona/paciente en la base de
     * datos
     *
     * @param objetoGuardar persona a guardar
     * @return true si guarda correcamente, de lo contrario false
     */
    Boolean guardarObjeto(Object objetoGuardar);

    /**
     * Servicio encargado de actualizar una entidad en la base de datos
     *
     * @param objetoActualizar objeto que se va a actualizar
     * @return true si se actualiza correctamente, de lo contrario false
     */
    Boolean actualizarObjeto(Object objetoActualizar);

    /**
     *
     * Metodo encargado de eliminar una atención, esto se utiliza cuando por
     * accidente se regista varias veces al paciente
     *
     * @param objetoEliminar Objeto a Eliminar
     * @return true si es correcto, de lo contrario false * Pendiente
     */
    Boolean eliminarObjeto(Object objetoEliminar);

}
