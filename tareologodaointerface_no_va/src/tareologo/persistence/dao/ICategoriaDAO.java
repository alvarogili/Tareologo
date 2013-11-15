package tareologo.persistence.dao;

import java.util.List;
import tareologo.model.Categoria;

/**
 * Agrupa métodos para la gestión de entidades de tipo @Categoria
 * en la base de datos
 * @author Alvaro Gili
 */
public interface ICategoriaDAO {
    
    /**
     * Retorna una @Categoria dado un nombre
     * @param nombre Nombre de la categoria a obtener
     * @return Retorna la categoria deseada o null en caso de que no exista
     */
    public Categoria getCategoria(String nombre);
    
    /**
     * Inserta una nueva categoria en la base de datos
     * @param categoria Categoria a insertar
     */
    public void insertCategoria(Categoria categoria);
    
    /**
     * Retorna todas las categorias almacenadas
     * @return Lista de categorias almacenadas
     */
    public List<Categoria> getCategorias();
    
    /**
     * Elimina una categoria dado su ID
     * @return True si pudo eliminarla
     */
    public boolean removeCategoria(long id);
    
    /**
     * Filtra las categorias por nombre dado un filtro
     * @param filter String contenido dentro del nombre
     * @return Lista de categorias que coinciden con el filtro
     */
    public List<Categoria> filterCategorias(String filter);
}
