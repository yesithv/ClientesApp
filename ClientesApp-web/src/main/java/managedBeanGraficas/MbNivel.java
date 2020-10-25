/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeanGraficas;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import managedBeanVarios.MbGeneral;
import org.primefaces.model.TreeNode;
import servicios.ServicioGraficas;

/**
 *
 * @author YesithV
 */
@ManagedBean
@ViewScoped
public class MbNivel extends MbGeneral implements Serializable {

    private TreeNode niveles;
    private TreeNode nivelSeleccionado;

    @EJB(beanName = "ServicioGraficasImpl")
    private ServicioGraficas servicioGraficas;

    @PostConstruct
    public void init() {
        this.niveles = servicioGraficas.cargarNiveles();
    }

    public TreeNode getNivelSeleccionado() {
        return nivelSeleccionado;
    }

    public void setNivelSeleccionado(TreeNode nivelSeleccionado) {
        this.nivelSeleccionado = nivelSeleccionado;
    }

    public TreeNode getNiveles() {
        return niveles;
    }

    public void setNiveles(TreeNode niveles) {
        this.niveles = niveles;
    }

}
