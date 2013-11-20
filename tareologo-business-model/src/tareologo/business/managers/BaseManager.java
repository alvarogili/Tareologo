package tareologo.business.managers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Base business' object manager
 * @author Alvaro
 */
public class BaseManager {
    protected static EntityManagerFactory emf;

    public BaseManager() {
        emf = Persistence.createEntityManagerFactory("tareologo");
    }
    
    
}
