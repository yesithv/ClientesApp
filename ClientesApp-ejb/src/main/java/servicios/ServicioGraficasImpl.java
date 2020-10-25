/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.model.TreeNode;
import mapeo.AaClientes;
import org.primefaces.model.DefaultTreeNode;

/**
 *
 * @author YesithV
 */
@Stateful(name = "ServicioGraficasImpl")
public class ServicioGraficasImpl implements ServicioGraficas {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public TreeNode cargarNiveles() {
        TreeNode root = new DefaultTreeNode(new AaClientes(), null);
        short activo = 1;
        AaClientes clienteTemporal = new AaClientes(Integer.BYTES, "Pepito Perez", "123", activo);
        TreeNode documents = new DefaultTreeNode(clienteTemporal, root);
        TreeNode pictures = new DefaultTreeNode(clienteTemporal, root);
        TreeNode movies = new DefaultTreeNode(clienteTemporal, root);
         
        TreeNode work = new DefaultTreeNode(clienteTemporal, documents);
        TreeNode primefaces = new DefaultTreeNode(clienteTemporal, documents);
         
        //Documents
        TreeNode expenses = new DefaultTreeNode("document", clienteTemporal, work);
        TreeNode resume = new DefaultTreeNode("document", clienteTemporal, work);
        TreeNode refdoc = new DefaultTreeNode("document", clienteTemporal, primefaces);
         
        //Pictures
        TreeNode barca = new DefaultTreeNode("picture", clienteTemporal, pictures);
        TreeNode primelogo = new DefaultTreeNode("picture", clienteTemporal, pictures);
        TreeNode optimus = new DefaultTreeNode("picture", clienteTemporal, pictures);
         
        //Movies
        TreeNode pacino = new DefaultTreeNode(clienteTemporal, movies);
        TreeNode deniro = new DefaultTreeNode(clienteTemporal, movies);
         
        TreeNode scarface = new DefaultTreeNode("mp3", clienteTemporal, pacino);
        TreeNode carlitosWay = new DefaultTreeNode("mp3", clienteTemporal, pacino);
         
        TreeNode goodfellas = new DefaultTreeNode("mp3", clienteTemporal, deniro);
        TreeNode untouchables = new DefaultTreeNode("mp3", clienteTemporal, deniro);
         
        return root;
    }

}
