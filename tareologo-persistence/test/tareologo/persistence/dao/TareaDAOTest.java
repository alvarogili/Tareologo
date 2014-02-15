package tareologo.persistence.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.CategoriaEntity;
import tareologo.persistence.entities.ResponsableEntity;
import tareologo.persistence.entities.TareaEntity;

/**
 *
 * @author Alvaro
 */
public class TareaDAOTest {

    private static EntityManagerFactory emf;
    private static TareaDAO tareaDAO;
    private static CategoriaEntity categoriaEntity;
    private static TareaEntity tareaEntity;
    private static ResponsableEntity responsableEntity;

    public TareaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("tareologo_test");
        tareaDAO = new TareaDAO(emf);
        categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("categoria");
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        categoriaDAO.create(categoriaEntity);
        responsableEntity = new ResponsableEntity();
        responsableEntity.setNombre("José");
        responsableEntity.setApodo("pepe");
        responsableEntity.setEmail("jose@email.com");
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        responsableDAO.create(responsableEntity);
        tareaEntity = new TareaEntity();
        tareaEntity.setTitulo("titulo");
        tareaEntity.setCompletado(0);
        tareaEntity.setPrioridad("Baja");
        tareaEntity.setCategoria(categoriaEntity);
        tareaEntity.setResponsable(responsableEntity);
    }

    @After
    public void tearDown() throws NonexistentEntityException {
        System.out.println("Cleaning the database");
        //borro todo lo creado
        List<TareaEntity> tareaEntities = tareaDAO.findTareaEntityEntities();        
        for (TareaEntity currentTareaEntity : tareaEntities) {
            tareaDAO.destroy(currentTareaEntity.getId());
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() throws NonexistentEntityException, Exception{
        ResponsableDAO responsableDAO = new ResponsableDAO(emf);
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        responsableDAO.destroy(responsableEntity.getId());
        categoriaDAO.destroy(categoriaEntity.getId());
    }

    /**
     * Test of getEntityManager method, of class TareaDAO.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManager result = tareaDAO.getEntityManager();
        assertNotNull(result);
    }

    /**
     * Test of create method, of class TareaDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        int countBefore = tareaDAO.getTareaEntityCount();
        tareaDAO.create(tareaEntity);
        assertEquals(countBefore + 1, tareaDAO.getTareaEntityCount());
    }

    /**
     * Test of edit method, of class TareaDAO.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        tareaDAO.create(tareaEntity);
        tareaEntity.setTitulo("tarea_modified");
        tareaDAO.edit(tareaEntity);
        assertEquals("tarea_modified", tareaDAO.findTareaEntityByID(tareaEntity.getId()).getTitulo());
    }

    /**
     * Test of destroy method, of class TareaDAO.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int countBefore = tareaDAO.getTareaEntityCount();
        tareaDAO.create(tareaEntity);
        tareaDAO.destroy(tareaEntity.getId());
        assertEquals(countBefore, tareaDAO.getTareaEntityCount());
    }

    /**
     * Test of findTareaEntityEntities method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityEntities_0args() {
        System.out.println("findTareaEntityEntities");
        tareaDAO.create(tareaEntity);
        List result = tareaDAO.findTareaEntityEntities();
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findTareaEntityEntities method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityEntities_int_int() {
        System.out.println("findTareaEntityEntities");
        int maxResults = 2;
        int firstResult = 0;
        tareaDAO.create(tareaEntity);
        TareaEntity tareaEntity2 = new TareaEntity();
        tareaEntity2.setTitulo("titulo2");
        tareaEntity2.setCompletado(0);
        tareaEntity2.setPrioridad("Baja");
        tareaEntity2.setCategoria(categoriaEntity);
        tareaEntity2.setResponsable(responsableEntity);
        tareaDAO.create(tareaEntity2);

        List result = tareaDAO.findTareaEntityEntities(maxResults, firstResult);
        assertEquals(2, result.size());
    }

    /**
     * Test of findTareaEntityByID method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityByID() {
        System.out.println("findTareaEntityByID");
        tareaDAO.create(tareaEntity);
        TareaEntity result = tareaDAO.findTareaEntityByID(tareaEntity.getId());
        assertNotNull(result);
    }

    /**
     * Test of findTareaEntityByCompletado method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityByCompletado() {
        System.out.println("findTareaEntityByCompletado");
        tareaDAO.create(tareaEntity);
        List<TareaEntity> result = tareaDAO.findTareaEntityByCompletado(0);
        assertNotNull(result.size() > 0);
    }

    /**
     * Test of findTareaEntityByPrioridad method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityByPrioridad() {
        System.out.println("findTareaEntityByPrioridad");
        tareaDAO.create(tareaEntity);
        List<TareaEntity> result = tareaDAO.findTareaEntityByPrioridad(1);
        assertNotNull(result.size() > 0);
    }

    /**
     * Test of findTareaEntityByTitulo method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityByTitulo() {
        System.out.println("findTareaEntityByTitulo");
        tareaDAO.create(tareaEntity);
        List<TareaEntity> result = tareaDAO.findTareaEntityByTitulo("titulo");
        assertNotNull(result.size() > 0);
    }

    /**
     * Test of findTareaEntityByVencimiento method, of class TareaDAO.
     */
    @Test
    public void testFindTareaEntityByVencimiento() {
        System.out.println("findTareaEntityByVencimiento");
        Date expiry = new Date();
        tareaEntity.setVencimiento(expiry);
        tareaDAO.create(tareaEntity);
        List<TareaEntity> result = tareaDAO.findTareaEntityByVencimiento(expiry);
        assertNotNull(result.size() > 0);
    }

    /**
     * Test of getTareaEntityCount method, of class TareaDAO.
     */
    @Test
    public void testGetTareaEntityCount() {
        System.out.println("getTareaEntityCount");
        tareaDAO.create(tareaEntity);
        assertTrue(tareaDAO.getTareaEntityCount() > 0);
    }

}
