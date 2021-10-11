package dao;

import lombok.NoArgsConstructor;
import models.Occupation;
import util.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@NoArgsConstructor
public class OccupationDao {

    public Occupation find(Long id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.find(Occupation.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Occupation> list() {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.createQuery("select o from Occupation o order by id")
                .getResultList();
    }

    public void insert(Occupation occupation) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(occupation);
        transaction.commit();
        manager.close();
    }

    public Occupation update(Occupation occupation) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        Occupation result;

        transaction.begin();
        result = manager.merge(occupation);
        transaction.commit();
        manager.close();
        return result;
    }

    public void remove(Long id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.createNativeQuery("delete from employee_occupations where occupations_id = ?")
                .setParameter(1,id)
                .executeUpdate();
        transaction.commit();

        transaction.begin();
        manager.createQuery("delete from Occupation where id= :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        manager.close();
    }

    public Boolean isPresent(Occupation occupation) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.contains(occupation);
    }
}
