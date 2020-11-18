package br.com.descompila.model.bean.dao;

import br.com.descompila.connection.ConnectionFactory;
import br.com.descompila.model.bean.Categoria;
import br.com.descompila.model.bean.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private final EntityManager entityManager = new ConnectionFactory().getConnection();

    public Produto save(Produto produto){
        try {
            entityManager.getTransaction().begin();
            if(produto.getId() == null) {
                entityManager.persist(produto);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return produto;
    }

    public void merge(Produto produto){
        try {
            entityManager.getTransaction().begin();
            if(produto.getId() != null){
                entityManager.merge(produto);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ignored) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public Produto findById(Integer id){
        Produto produto = null;
        try {
            produto = entityManager.find(Produto.class, id);
            if(produto == null){
                throw new NullPointerException("Produto não encontrado.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return produto;
    }

    public List<Produto> findAll(){
        List<Produto> produtoList = null;
        try{
            produtoList = entityManager.createQuery("from Produto").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return produtoList;
    }
}
