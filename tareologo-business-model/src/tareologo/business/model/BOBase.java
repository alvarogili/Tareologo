
package tareologo.business.model;

import java.io.Serializable;

/**
 * Business object base
 * @author Alvaro
 * @param <T> Entity object
 */
public class BOBase <T> implements Serializable{
    
    protected T entity;

    public BOBase() {
    }

    public BOBase(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
    
    
}
