package org.example.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;

import java.util.List;


public class CrudRepositoryImpl<T extends Model> implements CrudRepositoryInterface<T>{
    private final String entityName;
    private final Class<T> className;

    public CrudRepositoryImpl(String entityName, Class<T> className) {
        this.entityName = entityName;
        this.className = className;
    }
    @Override
    public void addItem(T t) {


        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        T currentT = em.getReference(className, t.getId());
        try {
            currentT.getName();
            T newObject = (T) new Model(t);
            System.out.println(newObject);
            em.persist(newObject);
            em.flush();
        }
        catch(EntityNotFoundException e) {
            System.out.println("Entity Not Found Exception Caught!!! ");
            try {
                em.persist(t);
                em.flush();
                System.out.println(t.getId());
            }
            catch(Exception ee) {

            }
        }

        em.getTransaction().commit();
        em.close();
    }
    @Override
    public void deleteItem(T t) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if(!em.contains(t))
            t = em.merge(t);

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
        if(!em.contains(currentObject))
           em.merge(currentObject);
        int currID = currentObject.getId();
        currentObject.make(t);
        currentObject.setId(currID);
        em.merge(currentObject);
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

    @Override
    public void reset() {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery(entityName + ".reset");
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
