package tareologo.persistence.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.ResponsableEntity;

/**
 * Responsable DAO
 * @author Alvaro Gili
 */
public class ResponsableDAO implements Serializable {

    public ResponsableDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Creates and inserts a {@link ResponsableEntity}
     * @param responsableEntity Object to insert
     */
    public void create(ResponsableEntity responsableEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(responsableEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edit a {@link ResponsableEntity}
     * @param responsableEntity Object to edit
     * @throws NonexistentEntityException
     * @throws Exception 
     */
    public void edit(ResponsableEntity responsableEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            responsableEntity = em.merge(responsableEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = responsableEntity.getId();
                if (findResponsableEntityByID(id) == null) {
                    throw new NonexistentEntityException("The responsableEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Deletes a {@link ResponsableEntity} given the ID
     * @param id ID of the object to remove
     * @throws NonexistentEntityException 
     */
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ResponsableEntity responsableEntity;
            try {
                responsableEntity = em.getReference(ResponsableEntity.class, id);
                responsableEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The responsableEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(responsableEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Return all {@link ResponsableEntity}s stored in the DB
     *
     * @return
     */
    public List<ResponsableEntity> findResponsableEntityEntities() {
        return findResponsableEntityEntities(true, -1, -1);
    }

    /**
     * Return a list of {@link ResponsableEntity} starting in firstResult and ending in
     * firstResult + maxResults
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<ResponsableEntity> findResponsableEntityEntities(int maxResults, int firstResult) {
        return findResponsableEntityEntities(false, maxResults, firstResult);
    }

    private List<ResponsableEntity> findResponsableEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResponsableEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Return a {@link ResponsableEntity} given a ID
     *
     * @param id ID of the {@link ResponsableEntity} to find
     * @return The {@link ResponsableEntity} or null
     */
    public ResponsableEntity findResponsableEntityByID(Integer id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ResponsableEntity.findById", ResponsableEntity.class);
            q.setParameter("id", id);
            return (ResponsableEntity) q.getSingleResult();
        } finally {
            em.close();
        }
    }
    
    /**
     * Return a list of {@link ResponsableEntity} given a nombre
     *
     * @param nombre name of the {@link ResponsableEntity} to find
     * @return The {@link ResponsableEntity} or null
     */
    public List<ResponsableEntity> findResponsableEntityByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ResponsableEntity.findByNombre", ResponsableEntity.class);
            q.setParameter("nombre", nombre);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * Return a list of {@link ResponsableEntity} given an apodo
     *
     * @param apodo byname of the {@link ResponsableEntity} to find
     * @return The {@link ResponsableEntity} or null
     */
    public List<ResponsableEntity> findResponsableEntityByApodo(String apodo) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ResponsableEntity.findByApodo", ResponsableEntity.class);
            q.setParameter("apodo", apodo);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * Return a list of {@link ResponsableEntity} given an email
     *
     * @param email email of the {@link ResponsableEntity} to find
     * @return The {@link ResponsableEntity} or null
     */
    public List<ResponsableEntity> findResponsableEntityByEmail(String email) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ResponsableEntity.findByEmail", ResponsableEntity.class);
            q.setParameter("email", email);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Return the amount of {@link ResponsableEntity} in the DB
     *
     * @return
     */
    public int getResponsableEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResponsableEntity> rt = cq.from(ResponsableEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
