/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ejb.Remote;
import org.primefaces.model.TreeNode;

/**
 *
 * @author YesithV
 */
@Remote
public interface ServicioGraficas {

    /**
     * Metodo encargado de cargar los niveles para luego graficarlos en el arbol
     *
     * @return Objeto con los niveles del arbol
     */
    TreeNode cargarNiveles();

}
