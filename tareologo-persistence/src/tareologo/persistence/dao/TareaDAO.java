package tareologo.persistence.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.TareaEntity;

/**
 * Tarea DAO
 * @author Alvaro Gili
 */
public class TareaDAO implements Serializable {

    public TareaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Creates and inserts a {@link TareaEntity}
     * @param tareaEntity Object to insert
     */
    public void create(TareaEntity tareaEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tareaEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edit a {@link TareaEntity}
     * @param tareaEntity Object to edit
     * @throws NonexistentEntityException
     * @throws Exception 
     */
    public void edit(TareaEntity tareaEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tareaEntity = em.merge(tareaEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tareaEntity.getId();
                if (findTareaEntityByID(id) == null) {
                    throw new NonexistentEntityException("The tareaEntity with id " + id + " no longer exists.");
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
     * Deletes a {@link TareaEntity} given the ID
     * @param id ID of the object to remove
     * @throws NonexistentEntityException 
     */
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TareaEntity tareaEntity;
            try {
                tareaEntity = em.getReference(TareaEntity.class, id);
                tareaEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tareaEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(tareaEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Return all {@link TareaEntity}s stored in the DB
     *
     * @return
     */
    public List<TareaEntity> findTareaEntityEntities() {
        return findTareaEntityEntities(true, -1, -1);
    }

     /**
     * Return a list of {@link TareaEntity} starting in firstResult and ending in
     * firstResult + maxResults
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<TareaEntity> findTareaEntityEntities(int maxResults, int firstResult) {
        return findTareaEntityEntities(false, maxResults, firstResult);
    }

    private List<TareaEntity> findTareaEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TareaEntity.class));
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
     * Return a {@link TareaEntity} given an ID
     *
     * @param id ID of the {@link TareaEntity} to find
     * @return The {@link TareaEntity} or null
     */
    public TareaEntity findTareaEntityByID(Integer id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("TareaEntity.findById", TareaEntity.class);
            q.setParameter("id", id);
            return (TareaEntity) q.getSingleResult();
        } finally {
            em.close();
        }
    }
    
   /**
     * Return a list of {@link TareaEntity} given a percentaje
     *
     * @param percentaje percentaje of the {@link TareaEntity} to find
     * @return The {@link TareaEntity} or null
     */
    public List<TareaEntity> findTareaEntityByCompletado(float percentaje) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("TareaEntity.findByCompletado", TareaEntity.class);
            q.setParameter("completado", percentaje);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
     /**
     * Return a list of {@link TareaEntity} given a priority
     *
     * @param priority priority of the {@link TareaEntity} to find
     * @return The {@link TareaEntity} or null
     */
    public List<TareaEntity> findTareaEntityByPrioridad(int priority) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("TareaEntity.findByPrioridad", TareaEntity.class);
            q.setParameter("prioridad", priority);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Return a list of {@link TareaEntity} given a title
     *
     * @param title title of the {@link TareaEntity} to find
     * @return The {@link TareaEntity} or null
     */
    public List<TareaEntity> findTareaEntityByTitulo(String title) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("TareaEntity.findByTitulo", TareaEntity.class);
            q.setParameter("titulo", title);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * Return a list of {@link TareaEntity} given a expiry time
     *
     * @param expiry expiry time of the {@link TareaEntity} to find
     * @return The {@link TareaEntity} or null
     */
    public List<TareaEntity> findTareaEntityByVencimiento(Date expiry) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("TareaEntity.findByVencimiento", TareaEntity.class);
            q.setParameter("vencimiento", expiry);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
     /**
     * Return the amount of {@link TareaEntity} in the DB
     *
     * @return
     */
    public int getTareaEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TareaEntity> rt = cq.from(TareaEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
