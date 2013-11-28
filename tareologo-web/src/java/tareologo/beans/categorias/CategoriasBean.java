/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.beans.categorias;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
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
        if (filter == null) {
            return categoriaManager.getAll();
        } else {
            return categoriaManager.findByName(filter);
        }
    }
    
    /**
     * Return a list of categorias for a combo box
     *
     * @return
     */
    public List<SelectItem> getCategoriasItems() {
        List<SelectItem> categoriasItems = new ArrayList<>();
        List<Categoria> categorias = categoriaManager.getAll();
        for(Categoria categoria: categorias){
            categoriasItems.add(new SelectItem(categoria.getId().toString(), categoria.getNombre()));
        }
        return categoriasItems;
    }

    public boolean containCategorias() {
        return getCategorias().size() > 0;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void removeFilter() {
        this.filter = null;
    }

    public void remove(int id) {
        try {
            categoriaManager.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(CategoriasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
