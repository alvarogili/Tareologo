/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tareologo.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.CategoriaEntity;

/**
 *
 * @author cnap
 */
public class CategoriaDAOTest {

    public CategoriaDAOTest() {
    }

    private static EntityManagerFactory emf;
    private static CategoriaDAO categoriaDao;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("tareologo_test");
        categoriaDao = new CategoriaDAO(emf);
    }
    
    @After
    public void tearDown() throws NonexistentEntityException, Exception{
        System.out.println("Cleaning the database");
        //borro todo lo creado
        List<CategoriaEntity> categoriaEntitys = categoriaDao.findCategoriaEntityEntities();
        for(CategoriaEntity categoriaEntity: categoriaEntitys){
            categoriaDao.destroy(categoriaEntity.getId());
        }
    }

    /**
     * Test of getEntityManager method, of class CategoriaDAO.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");

        EntityManager result = categoriaDao.getEntityManager();
        assertNotNull(result);
    }

    /**
     * Test of create method, of class CategoriaDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("categoria");
        int countBefore = categoriaDao.getCategoriaEntityCount();
        categoriaDao.create(categoriaEntity);
        assertEquals(countBefore + 1, categoriaDao.getCategoriaEntityCount());
    }

    /**
     * Test of edit method, of class CategoriaDAO.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("categoria");
        categoriaDao.create(categoriaEntity);
        categoriaEntity.setNombre("categoria_modified");
        categoriaDao.edit(categoriaEntity);
        assertEquals("categoria_modified", categoriaDao.findCategoriaEntityByID(categoriaEntity.getId()).getNombre());
    }

    /**
     * Test of destroy method, of class CategoriaDAO.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("categoria");
        int countBefore = categoriaDao.getCategoriaEntityCount();
        categoriaDao.create(categoriaEntity);        
        categoriaDao.destroy(categoriaEntity.getId());
        assertEquals(countBefore, categoriaDao.getCategoriaEntityCount());
    }

    /**
     * Test of findCategoriaEntityByIDEntities method, of class CategoriaDAO.
     */
    @Test
    public void testFindCategoriaEntityEntities_0args() {
        System.out.println("findCategoriaEntityEntities");
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("categoria");       
        categoriaDao.create(categoriaEntity);  
        List result = categoriaDao.findCategoriaEntityEntities();
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findCategoriaEntityByIDEntities method, of class CategoriaDAO.
     */
    @Test
    public void testFindCategoriaEntityEntities_int_int() {
        System.out.println("findCategoriaEntityEntities");
        int maxResults = 2;
        int firstResult = 0;
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("categoria");       
        categoriaDao.create(categoriaEntity);  
        CategoriaEntity categoriaEntity2 = new CategoriaEntity();
        categoriaEntity2.setNombre("categoria2");       
        categoriaDao.create(categoriaEntity2);  
        
        List result = categoriaDao.findCategoriaEntityEntities(maxResults, firstResult);
        assertEquals(2, result.size());        
    }

    /**
     * Test of findCategoriaEntityByID method, of class CategoriaDAO.
     */
    @Test
    public void testFindCategoriaEntityByID() {
        System.out.println("findCategoriaEntityByID");        
        CategoriaEntity categoriaEntity =  new CategoriaEntity();
        categoriaEntity.setNombre("categoria"); 
        categoriaDao.create(categoriaEntity);
        CategoriaEntity result = categoriaDao.findCategoriaEntityByID(categoriaEntity.getId());
        assertNotNull(result);        
    }
    
    /**
     * Test of findCategoriaEntityByNombre method, of class CategoriaDAO.
     */
    @Test
    public void testFindCategoriaEntityByNombre() {
        System.out.println("findCategoriaEntityByNombre");        
        CategoriaEntity categoriaEntity =  new CategoriaEntity();
        String categoriaNombre = "pruebaNombre";
        categoriaEntity.setNombre(categoriaNombre); 
        categoriaDao.create(categoriaEntity);
        List<CategoriaEntity> result = categoriaDao.findCategoriaEntityByNombre(categoriaNombre);
        assertFalse(result.isEmpty()); 
        assertEquals(categoriaNombre, result.get(0).getNombre());
    }

    /**
     * Test of getCategoriaEntityCount method, of class CategoriaDAO.
     */
    @Test
    public void testGetCategoriaEntityCount() {
        System.out.println("getCategoriaEntityCount");
        CategoriaEntity categoriaEntity =  new CategoriaEntity();
        String categoriaNombre = "pruebaNombre";
        categoriaEntity.setNombre(categoriaNombre); 
        categoriaDao.create(categoriaEntity);
        assertTrue(categoriaDao.getCategoriaEntityCount() > 0);
    }
}
