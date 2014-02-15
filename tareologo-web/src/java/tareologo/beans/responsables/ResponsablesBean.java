/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.beans.responsables;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.RollbackException;
import tareologo.business.managers.ResponsableManager;
import tareologo.business.model.Responsable;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;

/**
 *
 * @author Alvaro
 */
@ManagedBean(name = "ResponsablesBean")
@SessionScoped
public class ResponsablesBean {

    private ResponsableManager responsableManager = new ResponsableManager();
    private String filter;
    private String selectedItem;

    /**
     * Creates a new instance of ResponsablesBean
     */
    public ResponsablesBean() {
        selectedItem = "Nombre";
    }

    /**
     * Borra un responsable de la lista
     *
     * @param id ID del responsable a borrar
     * @return 0: ok, 1: no existe, 2: no pudo ser borrado
     */
    public String remove(int id) {
        try {
            responsableManager.delete(id);
        } catch (RollbackException | NonexistentEntityException ex) {
            return "error";
        }
        return "responsables";
    }

    public List<Responsable> getResponsables() {
        if (filter == null) {
            //No se aplicó un filtro
            return responsableManager.getAll();
        } else {
            if (selectedItem.equals("Nombre")) {
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

    public List<SelectItem> getItems() {
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem("Nombre", "Nombre"));
        items.add(new SelectItem("Email", "Email"));
        return items;
    }

    /**
     * Return a list of responsables for a combo box
     *
     * @return
     */
    public List<SelectItem> getResponsablesItems() {
        List<SelectItem> responsablesItems = new ArrayList<>();
        List<Responsable> responsables = responsableManager.getAll();
        for (Responsable responsable : responsables) {
            responsablesItems.add(new SelectItem(responsable.getId().toString(), responsable.getNombre()));
        }
        return responsablesItems;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
}
