/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.business.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import tareologo.business.model.Responsable;
import tareologo.persistence.dao.ResponsableDAO;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.ResponsableEntity;

/**
 * Responsables' manager
 *
 * @author Alvaro Gili
 */
public class ResponsableManager extends BaseManager implements IBaseManager<Responsable> {

    @Override
    public void create(Responsable object) throws Exception {
        if (object.getEntity().getId() == null) {
            ResponsableDAO responsableDAO = new ResponsableDAO(emf);
            responsableDAO.create(object.getEntity());
        } else {
            update(object);
        }
    }

    @Override
    public Responsable retrieve(int objectID) {
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        ResponsableEntity responsableEntity = responsableDAO.findResponsableEntityByID(objectID);
        if (responsableEntity == null) {
            return null;
        }
        Responsable responsable = new Responsable();
        responsable.setEntity(responsableEntity);
        return responsable;
    }

    @Override
    public void update(Responsable object) {
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        try {
            responsableDAO.edit(object.getEntity());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ResponsableManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ResponsableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int objectID) throws RollbackException, NonexistentEntityException {
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        ResponsableEntity responsableEntity = responsableDAO.findResponsableEntityByID(objectID);
        if (responsableEntity != null) {
                responsableDAO.destroy(responsableEntity.getId());
        }
    }

    @Override
    public List<Responsable> getAll() {
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        List<ResponsableEntity> responsableEntities = responsableDAO.findResponsableEntityEntities();
        List<Responsable> responsables = new ArrayList<>();
        for (ResponsableEntity responsableEntity : responsableEntities) {
            Responsable responsable = new Responsable();
            responsable.setEntity(responsableEntity);
            responsables.add(responsable);
        }
        return responsables;
    }

    public List<Responsable> findByName(String name) {
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        List<ResponsableEntity> responsableEntities = responsableDAO.findResponsableEntityByNombre(name);
        List<Responsable> responsables = new ArrayList<>();
        for (ResponsableEntity responsableEntity : responsableEntities) {
            Responsable responsable = new Responsable();
            responsable.setEntity(responsableEntity);
            responsables.add(responsable);
        }
        return responsables;
    }

    public List<Responsable> findByEmail(String email) {
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        List<ResponsableEntity> responsableEntities = responsableDAO.findResponsableEntityByEmail(email);
        List<Responsable> responsables = new ArrayList<>();
        for (ResponsableEntity responsableEntity : responsableEntities) {
            Responsable responsable = new Responsable();
            responsable.setEntity(responsableEntity);
            responsables.add(responsable);
        }
        return responsables;
    }
}
