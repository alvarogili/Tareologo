/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    public void remove(long id) {
//        responsableDAO.removeResponsable(id);        
    }

    public List<Responsable> getResponsables() {
        if (filter == null) {
            //No se aplicó un filtro
            return responsableManager.getAll();
        } else {
            return responsableManager.findByName(filter);
        }
    }

   

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
