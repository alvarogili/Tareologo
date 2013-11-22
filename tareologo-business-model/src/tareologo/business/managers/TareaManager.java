/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tareologo.business.managers;

import java.util.ArrayList;
import java.util.List;
import tareologo.business.model.Tarea;
import tareologo.persistence.dao.TareaDAO;
import tareologo.persistence.entities.TareaEntity;

/**
 *
 * @author Alvaro Gili
 */
public class TareaManager extends BaseManager implements IBaseManager<Tarea>{    

    @Override
    public void create(Tarea object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tarea retrieve(int objectID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Tarea object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int objectID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tarea> getAll() {
        TareaDAO tareaDAO = new TareaDAO(emf);
        List<TareaEntity> tareaEntities =  tareaDAO.findTareaEntityEntities();
        List<Tarea> tareas = new ArrayList<>();
        for(TareaEntity tareaEntity: tareaEntities){
            Tarea tarea = new Tarea();
            tarea.setEntity(tareaEntity);
            tareas.add(tarea);
        }
        return tareas;
    }

}
