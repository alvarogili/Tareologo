
package tareologo.beans.tareas;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tareologo.business.managers.TareaManager;
import tareologo.business.model.Tarea;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "TareasBean")
@SessionScoped
public class TareasBean {
    
    private List<Tarea> tareas;
    private TareaManager tareaManager = new TareaManager();

    /**
     * Creates a new instance of TareasBean
     */
    public TareasBean() {
    }

    public List<Tarea> getTareas() {
        tareas = tareaManager.getAll();
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    
    
}
