/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tareologo.business.model.Responsable;

/**
 *
 * @author Alvaro
 */
@ManagedBean(name = "ResponsablesBean")
@SessionScoped
public class ResponsablesBean {

//    @EJB
//    private IResponsableDAO responsableDAO;
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
//        if (filter == null) {
//            //No se aplicó un filtro
//            return responsableDAO.getResponsables();
//        } else {
//            List<Responsable> result = responsableDAO.filterResponsables(filter);
//            filter = null;
//            return result;
//        }
        return null;
    }

   

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
