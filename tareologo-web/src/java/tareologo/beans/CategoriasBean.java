/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tareologo.business.managers.CategoriaManager;
import tareologo.business.model.Categoria;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "CategoriasBean")
@SessionScoped
public class CategoriasBean {

    private CategoriaManager categoriaManager = new CategoriaManager();
    private String filter;

    /**
     * Creates a new instance of CategoriasBean
     */
    public CategoriasBean() {
    }

    public List<Categoria> getCategorias() {
        List<Categoria> categorias;
        if (filter == null) {
            categorias = categoriaManager.getAll();
        } else {
            categorias = categoriaManager.findByName(filter);
            filter = null;
        }
        return categorias;
    }

    public String getFilter() {
        return filter;
    }

    public String setFilter(String filter) {
        this.filter = filter;
        return "categorias";
    }

    public void remove(int id) {
        try {
            categoriaManager.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(CategoriasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
