
package tareologo.beans.tareas;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import tareologo.business.managers.TareaManager;
import tareologo.business.model.Tarea;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "TareasBean")
@SessionScoped
public class TareasBean {
    
    private final TareaManager tareaManager = new TareaManager();
    private String prioridadSelected;
    private String filter;
    private String responsable;
    private boolean completadas;

    /**
     * Creates a new instance of TareasBean
     */
    public TareasBean() {
    }

    public List<Tarea> getTareas() {
        if((filter != null && !filter.isEmpty()) || 
                (responsable != null && !responsable.isEmpty()) || 
                completadas){
            return tareaManager.customFind(filter, responsable, completadas);
        }else{
            return tareaManager.getAll();
        }
    }

    public String getPrioridadSelected() {
        return prioridadSelected;
    }

    public void setPrioridadSelected(String prioridadSelected) {
        this.prioridadSelected = prioridadSelected;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getResponsable() {
        return responsable;
    }        

    public boolean getCompletadas() {
        return completadas;
    }

    public void setCompletadas(boolean completadas) {
        this.completadas = completadas;
    }
    
    public void removeFilter(){
        this.filter = null;
        this.responsable = null;
        this.completadas = false;
    }
    
    public List<SelectItem> getItemsPrioridad() {
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem("Baja"));
        items.add(new SelectItem("Normal"));
        items.add(new SelectItem("Alta"));
        items.add(new SelectItem("Urgente"));
        return items;
    }
    
    public List<SelectItem> getCompletadoItems(){
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem("0"));
        items.add(new SelectItem("10"));
        items.add(new SelectItem("20"));
        items.add(new SelectItem("30"));
        items.add(new SelectItem("40"));
        items.add(new SelectItem("50"));
        items.add(new SelectItem("60"));
        items.add(new SelectItem("70"));
        items.add(new SelectItem("80"));
        items.add(new SelectItem("90"));
        items.add(new SelectItem("100"));
        return items;
    }
    
    public void remove(int id) throws Exception{
        tareaManager.delete(id);
    }
}
