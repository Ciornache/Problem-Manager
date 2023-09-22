package org.example.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.author.Author;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class CrudRepository <T extends Serializable> implements CrudRepositoryInterface<T>{
    private final String entityName;
    private  Class<T> className;

    public CrudRepository(String entityName, Class<T> className) {
        this.entityName = entityName;
        this.className = className;
    }
    @Override
    public void addItem(T t) {
        System.out.println("HERE");
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();



        if(em.contains(t))
            em.merge(t);
        else
            em.persist(t);

        em.getTransaction().commit();
        em.close();
    }
    @Override
    public void deleteItem(T t) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteItem(int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T t = em.getReference(className, id);
        em.remove(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateItem(T t, int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T currentObject = this.findById(id);
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public List<T> selectAll() {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery(entityName + ".selectAll");
        List<T> list = query.getResultList();
        em.close();
        return list;
    }
    @Override
    public T findById(int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery(entityName + ".findById");
        query.setParameter("id", id);
        List<T> list = query.getResultList();
        if(list.size() == 0)
            return null;
        return list.get(0);
    }
    @Override
    public T findByName(String name) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery(entityName + ".findByName");
        query.setParameter("name", name);
        List<T> list = query.getResultList();
        if(list.size() == 0)
            return null;
        return list.get(0);
    }


}
