package tareologo.business.managers;

import java.util.ArrayList;
import java.util.List;
import tareologo.business.model.Categoria;
import tareologo.persistence.dao.CategoriaDAO;
import tareologo.persistence.dao.exceptions.NonexistentEntityException;
import tareologo.persistence.entities.CategoriaEntity;

/**
 * Categoria's manager
 * @author Alvaro
 */
//@Stateless
public class CategoriaManager extends BaseManager implements IBaseManager<Categoria>{      

    @Override
    public void create(Categoria object) throws Exception {
        if(object.getEntity().getId() == null){
            CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
            categoriaDAO.create(object.getEntity());
        }else{
            update(object);
        }
    }

    @Override
    public Categoria retrieve(int objectID) {
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        CategoriaEntity categoriaEntity = categoriaDAO.findCategoriaEntityByID(objectID);
        if(categoriaEntity == null){
            return null;
        }
        Categoria categoria = new Categoria();
        categoria.setEntity(categoriaEntity);
        return categoria;
    }

    @Override
    public void update(Categoria object) throws Exception {
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        CategoriaEntity categoriaEntity = categoriaDAO.findCategoriaEntityByID(object.getEntity().getId());
        if(categoriaEntity != null){
            try {
                //exists in the DB
                categoriaDAO.edit(object.getEntity());
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        }
        
    }

    @Override
    public void delete(int objectID) throws Exception {
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        CategoriaEntity categoriaEntity = categoriaDAO.findCategoriaEntityByID(objectID);
        if(categoriaEntity != null){
            try {
                categoriaDAO.destroy(objectID);
            } catch (NonexistentEntityException ex) {
                throw new Exception(ex);
            }
        }
    }

    @Override
    public List<Categoria> getAll() {
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        List<CategoriaEntity> categoriaEntities = categoriaDAO.findCategoriaEntityEntities();
        List<Categoria> categorias = new ArrayList<>();
        for(CategoriaEntity categoriaEntity:categoriaEntities){
            Categoria categoria = new Categoria();
            categoria.setEntity(categoriaEntity);
            categorias.add(categoria);
        }
        return categorias;
    }
  
    public List<Categoria> findByName(String name){
        CategoriaDAO categoriaDAO = new CategoriaDAO(emf);
        List<CategoriaEntity> categoriaEntities = categoriaDAO.findCategoriaEntityByNombre(name);
        List<Categoria> categorias = new ArrayList<>();
        for(CategoriaEntity categoriaEntity:categoriaEntities){
            Categoria categoria = new Categoria();
            categoria.setEntity(categoriaEntity);
            categorias.add(categoria);
        }
        return categorias;
    }
}
