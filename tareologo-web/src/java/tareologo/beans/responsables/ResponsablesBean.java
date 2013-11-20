/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.beans.responsables;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import tareologo.business.managers.ResponsableManager;
import tareologo.business.model.Responsable;

/**
 *
 * @author Alvaro
 */
@ManagedBean(name = "ResponsablesBean")
@SessionScoped
public class ResponsablesBean {

    private ResponsableManager responsableManager = new ResponsableManager();
    private String filter;
    private SelectItem selectedItem;

    /**
     * Creates a new instance of ResponsablesBean
     */
    public ResponsablesBean() {
    }

    /**
     * Borra un responsable de la lista
     *
     * @param id ID del responsable a borrar
     * @return
     */
    public void remove(int id) {
        responsableManager.delete(id);
    }

    public List<Responsable> getResponsables() {
        if (filter == null) {
            //No se aplicó un filtro
            return responsableManager.getAll();
        } else {
            if (selectedItem.getValue().equals("Nombre")) {
                return responsableManager.findByName(filter);
            } else {
                return responsableManager.findByEmail(filter);
            }
        }
    }

    public void removeFilter() {
        this.filter = null;
        this.selectedItem = null;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public SelectItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(SelectItem item) {
        this.selectedItem = item;
    }

    public List<SelectItem> getItems() {
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem("Nombre"));
        items.add(new SelectItem("Email"));
        return items;
    }
}
