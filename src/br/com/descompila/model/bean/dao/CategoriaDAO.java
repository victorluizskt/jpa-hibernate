package br.com.descompila.model.bean.dao;

import br.com.descompila.connection.ConnectionFactory;
import br.com.descompila.model.bean.Categoria;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {
    private final EntityManager entityManager = new ConnectionFactory().getConnection();

    public Categoria save(Categoria categoria){
        try {
            entityManager.getTransaction().begin();
            if(categoria.getId() == null) {
                entityManager.persist(categoria);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return categoria;
    }

    public void merge(Categoria categoria){
        try {
            entityManager.getTransaction().begin();
            if(categoria.getId() != null){
                entityManager.merge(categoria);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public Categoria findById(Integer id){
        Categoria categoria = null;
        try {
            categoria = entityManager.find(Categoria.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return categoria;
    }

    public List<Categoria> findAll(){
        List<Categoria> categoriaList = null;
        try{
            categoriaList = entityManager.createQuery("from Categoria").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return categoriaList;
    }

    public Categoria remove(Integer id){
        Categoria categoria = null;
        try {
            categoria = entityManager.find(Categoria.class, id);
            if(categoria != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(categoria);
                entityManager.getTransaction().commit();
            } else {
                throw new NullPointerException("Item não existe.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return categoria;
    }
}
