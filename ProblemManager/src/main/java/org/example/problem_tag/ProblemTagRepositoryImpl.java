package org.example.problem_tag;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.problem.Problem;
import org.example.utils.EntityBuilder;

import java.util.List;

public class ProblemTagRepositoryImpl implements ProblemTagRepository{
    @Override
    public void addItem(ProblemTag problemTag) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if(em.contains(problemTag))
            em.merge(problemTag);
        else
            em.persist(problemTag);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteItem(ProblemTag problemTag) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Problem instance = em.getReference(Problem.class, problemTag.getId());
        em.remove(instance);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateItem(ProblemTag problemTag, int id) {

    }

    @Override
    public List<ProblemTag> selectAll() {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Problem.selectAll");
        List<ProblemTag> problemTagList = query.getResultList();
        if(problemTagList.size() == 0)
            return null;
        return problemTagList;
    }

    @Override
    public ProblemTag findById(int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Problem.selectAll");
        List<ProblemTag> problemTagList = query.getResultList();
        if(problemTagList.size() == 0)
            return null;
        return problemTagList.get(0);
    }

    @Override
    public ProblemTag findByName(int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Problem.selectAll");
        List<ProblemTag> problemTagList = query.getResultList();
        if(problemTagList.size() == 0)
            return null;
        return problemTagList.get(0);
    }
}
