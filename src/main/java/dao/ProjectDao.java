package dao;

import models.Project;
import util.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProjectDao {

    public Project find(Long id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.find(Project.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Project> list() {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.createQuery("select p from Project p order by id")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Project> listStatus(Boolean status) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.createQuery("select p from Project p where p.activeStatus= :status order by id")
                .setParameter("status", status)
                .getResultList();
    }

    public void insert(Project project) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(project);
        transaction.commit();
        manager.close();
    }

    public void update(Project project) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.merge(project);
        transaction.commit();
        manager.close();
    }

    public void remove(Long id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.createNativeQuery("delete from project_tasks where project_id = ?")
                .setParameter(1, id)
                .executeUpdate();
        transaction.commit();

        transaction.begin();
        manager.createQuery("delete from Project where id= :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        manager.close();
    }

    public Boolean isPresent(Project project) {
        return this.find(project.getId()) != null;
    }
}
