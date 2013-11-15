package tareologo.persistence.dao;

import java.util.List;
import tareologo.model.Tarea;

/**
 * Agrupa métodos para la gestión de entidades de tipo @Tarea
 * en la base de datos
 * @author Alvaro Gili
 */
public interface ITareaDAO {
    
    /**
     * Retorna una @Tarea dado un título
     * @param titulo Título de la Tarea a obtener
     * @return Retorna la Tarea deseada o null en caso de que no exista
     */
    public Tarea getTarea(String titulo);
    
    /**
     * Inserta una nueva Tarea en la base de datos
     * @param tarea Tarea a insertar
     */
    public void insertTarea(Tarea tarea);
    
    /**
     * Retorna todas las Tareas almacenadas
     * @return Lista de Tareas almacenadas
     */
    public List<Tarea> getTareas();
}
