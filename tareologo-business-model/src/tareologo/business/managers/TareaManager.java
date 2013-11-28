/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.business.managers;

import java.util.ArrayList;
import java.util.List;
import tareologo.business.model.Tarea;
import tareologo.persistence.dao.TareaDAO;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.TareaEntity;

/**
 *
 * @author Alvaro Gili
 */
public class TareaManager extends BaseManager implements IBaseManager<Tarea> {

    @Override
    public void create(Tarea object) throws Exception {
        if (object.getEntity().getId() == null) {
            TareaDAO tareaDAO = new TareaDAO(emf);
            tareaDAO.create(object.getEntity());
        } else {
            update(object);
        }
    }

    @Override
    public Tarea retrieve(int objectID) {
        TareaDAO tareaDAO = new TareaDAO(emf);
        TareaEntity tareaEntity = tareaDAO.findTareaEntityByID(objectID);
        if (tareaEntity == null) {
            return null;
        }
        Tarea tarea = new Tarea();
        tarea.setEntity(tareaEntity);
        return tarea;
    }

    @Override
    public void update(Tarea object) throws NonexistentEntityException, Exception {
        TareaDAO tareaDAO = new TareaDAO(emf);
        TareaEntity tareaEntity = tareaDAO.findTareaEntityByID(object.getID());
        if (tareaEntity != null) {
            tareaDAO.edit(tareaEntity);
        }
    }

    @Override
    public void delete(int objectID) throws Exception {
        TareaDAO tareaDAO = new TareaDAO(emf);
        TareaEntity tareaEntity = tareaDAO.findTareaEntityByID(objectID);
        if(tareaEntity != null){
            tareaDAO.destroy(tareaEntity.getId());
        }
    }

    @Override
    public List<Tarea> getAll() {
        TareaDAO tareaDAO = new TareaDAO(emf);
        List<TareaEntity> tareaEntities = tareaDAO.findTareaEntityEntities();
        List<Tarea> tareas = new ArrayList<>();
        for (TareaEntity tareaEntity : tareaEntities) {
            Tarea tarea = new Tarea();
            tarea.setEntity(tareaEntity);
            tareas.add(tarea);
        }
        return tareas;
    }
}
