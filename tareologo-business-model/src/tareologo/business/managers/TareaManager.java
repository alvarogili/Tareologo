/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.business.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tareologo.business.model.Tarea;
import tareologo.persistence.dao.TareaDAO;
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
    public void update(Tarea object) {
        TareaDAO tareaDAO = new TareaDAO(emf);
        try {
            tareaDAO.edit(object.getEntity());
        } catch (Exception ex) {
            Logger.getLogger(TareaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int objectID) throws Exception {
        TareaDAO tareaDAO = new TareaDAO(emf);
        TareaEntity tareaEntity = tareaDAO.findTareaEntityByID(objectID);
        if (tareaEntity != null) {
            tareaDAO.destroy(tareaEntity.getId());
        }
    }

    @Override
    public List<Tarea> getAll() {
        TareaDAO tareaDAO = new TareaDAO(emf);
        List<TareaEntity> tareaEntities = tareaDAO.findTareaEntityEntities();
        return makeList(tareaEntities);
    }

    public List<Tarea> findByTitle(String title) {
        TareaDAO tareaDAO = new TareaDAO(emf);
        List<TareaEntity> tareaEntities = tareaDAO.findTareaEntityByTitulo(title);
        return makeList(tareaEntities);
    }

    public List<Tarea> findByResponsale(String responsable) {
        TareaDAO tareaDAO = new TareaDAO(emf);
        List<TareaEntity> tareaEntities = tareaDAO.findTareaEntityByResponsable(responsable);
        return makeList(tareaEntities);
    }

    private List<Tarea> makeList(List<TareaEntity> tareaEntitys) {
        List<Tarea> tareas = new ArrayList<>();
        for (TareaEntity tareaEntity : tareaEntitys) {
            Tarea tarea = new Tarea();
            tarea.setEntity(tareaEntity);
            tareas.add(tarea);
        }
        return tareas;
    }
    
    public List<Tarea> customFind(String title, String responsale, boolean completado){
        TareaDAO tareaDAO = new TareaDAO(emf);
        List<TareaEntity> tareaEntities = tareaDAO.findTareaEntityCustom(title, responsale, completado);
        return makeList(tareaEntities);
    }
}
