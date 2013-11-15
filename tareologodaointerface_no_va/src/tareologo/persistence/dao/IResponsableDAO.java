package tareologo.persistence.dao;

import java.util.List;
import tareologo.model.Responsable;

/** 
 * Agrupa métodos para la gestión de entidades de tipo @Responsable
 * en la base de datos
 * @author Alvaro Gili
 */
public interface IResponsableDAO {
    
    /**
     * Retorna un @Responsable dado un nombre
     * @param nombre Nombre de la Responsable a obtener
     * @return Retorna el Responsable deseada o null en caso de que no exista
     */
    public Responsable getResponsable(String nombre);
    
    /**
     * Inserta un nuevo Responsable en la base de datos
     * @param responsable Responsable a insertar
     */
    public void insertResponsable(Responsable responsable);
    
    /**
     * Retorna todas los Responsables almacenados
     * @return Lista de Responsables almacenadaos
     */
    public List<Responsable> getResponsables();
    
    /**
     * Elimina un responsable dado su ID
     * @return True si pudo eliminarlo
     */
    public boolean removeResponsable(long id);
    
    /**
     * Filtra los responsables por nombre dado un filtro
     * @param filter String contenido dentro del nombre
     * @return Lista de responsables que coinciden con el filtro
     */
    public List<Responsable> filterResponsables(String filter);
}
