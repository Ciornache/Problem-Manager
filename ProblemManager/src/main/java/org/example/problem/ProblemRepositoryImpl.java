package org.example.problem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.utils.EntityBuilder;

import java.util.List;

public class ProblemRepositoryImpl implements ProblemRepository{
    @Override
    public void addItem(Problem problem) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Problem currProblem = em.find(Problem.class, problem.getId());
        try {
            currProblem.getName();
            problem = em.merge(problem);
        }
        catch(Exception e) {
            e.printStackTrace();
            try {
                em.persist(problem);
                em.flush();
            }
            catch(Exception ee) {

            }
        }

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteItem(Problem problem) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Problem instance = em.getReference(Problem.class, problem.getId());
        em.remove(instance);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateItem(Problem problem, int id) {

    }

    @Override
    public List<Problem> selectAll() {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Problem.selectAll");
        List<Problem> problemList = query.getResultList();
        if(problemList.size() == 0)
            return null;
        return problemList;
    }

    @Override
    public Problem findById(int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Problem.selectAll");
        List<Problem> problemList = query.getResultList();
        if(problemList.size() == 0)
            return null;
        return problemList.get(0);
    }

    @Override
    public Problem findByName(int id) {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Problem.selectAll");
        List<Problem> problemList = query.getResultList();
        if(problemList.size() == 0)
            return null;
        return problemList.get(0);
    }


    public static void reset() {
        EntityManagerFactory emf = EntityBuilder.getInstance();
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Problem.reset");
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
