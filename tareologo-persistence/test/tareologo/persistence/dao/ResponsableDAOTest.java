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
import tareologo.persistence.entities.ResponsableEntity;

/**
 *
 * @author alvaro
 */
public class ResponsableDAOTest {
    
    private static EntityManagerFactory emf;
    private static ResponsableDAO responsableDAO;
    
    public ResponsableDAOTest() {
    }
    
    @After
    public void tearDown() throws NonexistentEntityException {
        System.out.println("Cleaning the database");
        //borro todo lo creado
        List<ResponsableEntity> responsableEntities = responsableDAO.findResponsableEntityEntities();
        for(ResponsableEntity responsableEntity: responsableEntities){
            responsableDAO.destroy(responsableEntity.getId());
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("tareologo_test");
        responsableDAO = new ResponsableDAO(emf);
    }

    /**
     * Test of getEntityManager method, of class ResponsableDAO.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManager result = responsableDAO.getEntityManager();
        assertNotNull(result);
    }

    /**
     * Test of create method, of class ResponsableDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("pepe");      
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        int countBefore = responsableDAO.getResponsableEntityCount();
        responsableDAO.create(responsableEntity);
        assertEquals(countBefore + 1, responsableDAO.getResponsableEntityCount());
    }

    /**
     * Test of edit method, of class ResponsableDAO.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);
        responsableEntity.setNombre("responsable_modified");
        responsableDAO.edit(responsableEntity);
        assertEquals("responsable_modified", responsableDAO.findResponsableEntityByID(responsableEntity.getId()).getNombre());
    }

    /**
     * Test of destroy method, of class ResponsableDAO.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        int countBefore = responsableDAO.getResponsableEntityCount();
        responsableDAO.create(responsableEntity);        
        responsableDAO.destroy(responsableEntity.getId());
        assertEquals(countBefore, responsableDAO.getResponsableEntityCount());
    }

    /**
     * Test of findResponsableEntityEntities method, of class ResponsableDAO.
     */
    @Test
    public void testFindResponsableEntityEntities_0args() {
        System.out.println("findResponsableEntityEntities");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);
        assertTrue(responsableDAO.getResponsableEntityCount() > 0);
    }

    /**
     * Test of findResponsableEntityEntities method, of class ResponsableDAO.
     */
    @Test
    public void testFindResponsableEntityEntities_int_int() {
        System.out.println("findResponsableEntityEntities");
         int maxResults = 2;
        int firstResult = 0;
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");  
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);  
        ResponsableEntity responsableEntity2 = new ResponsableEntity();
        responsableEntity2.setNombre("responsable2"); 
        responsableEntity2.setApodo("apodo");
        responsableEntity2.setEmail("responsable2@mail.com");
        responsableDAO.create(responsableEntity2);  
        
        List result = responsableDAO.findResponsableEntityEntities(maxResults, firstResult);
        assertEquals(2, result.size());     
    }

    /**
     * Test of findResponsableEntityByID method, of class ResponsableDAO.
     */
    @Test
    public void testFindResponsableEntityByID() {
        System.out.println("findResponsableEntityByID");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");      
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);  
        ResponsableEntity result = responsableDAO.findResponsableEntityByID(responsableEntity.getId());
        assertNotNull(result);
    }

    /**
     * Test of findResponsableEntityByNombre method, of class ResponsableDAO.
     */
    @Test
    public void testFindResponsableEntityByNombre() {
        System.out.println("findResponsableEntityByNombre");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");     
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);  
        List<ResponsableEntity> result = responsableDAO.findResponsableEntityByNombre("responsable");
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findResponsableEntityByApodo method, of class ResponsableDAO.
     */
    @Test
    public void testFindResponsableEntityByApodo() {
         System.out.println("findResponsableEntityByApodo");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");       
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");      
        responsableDAO.create(responsableEntity);  
        List<ResponsableEntity> result = responsableDAO.findResponsableEntityByApodo("apodo");
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findResponsableEntityByEmail method, of class ResponsableDAO.
     */
    @Test
    public void testFindResponsableEntityByEmail() {
        System.out.println("findResponsableEntityByEmail");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");       
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);  
        List<ResponsableEntity> result = responsableDAO.findResponsableEntityByEmail("responsable@mail.com");
        assertTrue(result.size() > 0);
    }

    /**
     * Test of getResponsableEntityCount method, of class ResponsableDAO.
     */
    @Test
    public void testGetResponsableEntityCount() {
        System.out.println("getResponsableEntityCount");
        ResponsableEntity responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("responsable");       
        responsableEntity.setApodo("apodo");
        responsableEntity.setEmail("responsable@mail.com");
        responsableDAO.create(responsableEntity);  
        assertTrue(responsableDAO.getResponsableEntityCount() > 0);
    }
    
}
