package dao;

import util.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class GenericDao<T, ID extends Serializable> {

    private final Class<T> model;
    private final Class<ID> idModel;

    public GenericDao(Class<T> modelType, Class<ID> idType) {
        this.model = modelType;
        this.idModel = idType;
    }

    public T find(ID id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.find(model, id);
    }

    public List<? extends T> list() {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        CriteriaQuery<T> criteriaQ = manager.getCriteriaBuilder().createQuery(this.model);
        criteriaQ.select(criteriaQ.from(this.model));
        return manager.createQuery(criteriaQ).getResultList();
    }

    public void save(T object) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.merge(object);
        transaction.commit();
        manager.close();
    }

    public void delete(T object) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.remove(manager.contains(object) ? object : manager.merge(object) );
        transaction.commit();
        manager.close();
    }
}
