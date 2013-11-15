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
import tareologo.persistence.entities.CategoriaEntity;

/**
 * Categoria DAO
 *
 * @author Alvaro Gili
 */
public class CategoriaDAO implements Serializable {

    public CategoriaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Creates and inserts a {@link CategoriaEntity}
     *
     * @param categoriaEntity Object to insert
     */
    public void create(CategoriaEntity categoriaEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(categoriaEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edit a {@link CategoriaEntity}
     *
     * @param categoriaEntity Object to insert
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(CategoriaEntity categoriaEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            categoriaEntity = em.merge(categoriaEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = categoriaEntity.getId();
                if (findCategoriaEntityByID(id) == null) {
                    throw new NonexistentEntityException("The categoriaEntity with id " + id + " no longer exists.");
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
     * Remove a {@link CategoriaEntity} given the id
     *
     * @param id ID of the {@link CategoriaEntity} to remove
     * @throws NonexistentEntityException
     */
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CategoriaEntity categoriaEntity;
            try {
                categoriaEntity = em.getReference(CategoriaEntity.class, id);
                categoriaEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoriaEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(categoriaEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Return all {@link CategoriaEntity}s stored in the DB
     *
     * @return
     */
    public List<CategoriaEntity> findCategoriaEntityEntities() {
        return findCategoriaEntityEntities(true, -1, -1);
    }

    /**
     * Return a list of {@link CategoriaEntity} starting in firstResult and ending in
     * firstResult + maxResults
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<CategoriaEntity> findCategoriaEntityEntities(int maxResults, int firstResult) {
        return findCategoriaEntityEntities(false, maxResults, firstResult);
    }

    private List<CategoriaEntity> findCategoriaEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("CategoriaEntity.findAll", CategoriaEntity.class);
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
     * Return a {@link CategoriaEntity} given a ID
     *
     * @param id ID of the {@link CategoriaEntity} to find
     * @return The {@link CategoriaEntity} or null
     */
    public CategoriaEntity findCategoriaEntityByID(Integer id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("CategoriaEntity.findById", CategoriaEntity.class);
            q.setParameter("id", id);
            return (CategoriaEntity) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    /**
     * Return a list of {@link CategoriaEntity} given a nombre
     *
     * @param nombre name of the {@link CategoriaEntity} to find
     * @return The {@link CategoriaEntity} or null
     */
    public List<CategoriaEntity> findCategoriaEntityByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("CategoriaEntity.findByNombre", CategoriaEntity.class);
            q.setParameter("nombre", nombre);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Return the amount of {@link CategoriaEntity} in the DB
     *
     * @return
     */
    public int getCategoriaEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CategoriaEntity> rt = cq.from(CategoriaEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
