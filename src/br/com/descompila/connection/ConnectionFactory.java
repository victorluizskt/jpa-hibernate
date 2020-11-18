package br.com.descompila.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("meuPU");

    public EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }

}
