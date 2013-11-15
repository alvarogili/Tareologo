package tareologo.business.managers;

import java.util.List;
import tareologo.business.model.BOBase;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;

/**
 * Interface business' object manager
 *
 * @author Alvaro
 * @param <T> current object
 */
public interface IBaseManager<T extends BOBase> {

    /**
     * Creates and inserts a new object
     *
     * @param object Object to insert
     * @throws tareologo.persistence.dao.exceptions.NonexistentEntityException
     */
    public void create(T object) throws Exception;

    /**
     * Restore a object
     * @param objectID ID of the object to restore
     * @return The object searched or null
     */
    public T retrieve(int objectID);

    /**
     * Update a object given
     * @param object Object to update
     * @throws NonexistentEntityException
     * @throws Exception 
     */
    public void update(T object) throws Exception;

    /**
     * Remove a object from the DB
     * @param objectID ID of the object to remove
     * @throws NonexistentEntityException 
     */
    public void delete(int objectID) throws Exception;
    
    /**
     * Return all objects in the DB
     * @return 
     */
    public List<T> getAll();
}
