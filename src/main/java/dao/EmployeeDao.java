package dao;

import models.Employee;
import util.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeDao {

    public Employee find(Long id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.find(Employee.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> list() {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        return manager.createQuery("select e from Employee e order by id")
                .getResultList();
    }

    public void insert(Employee employee) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(employee);
        transaction.commit();
        manager.close();
    }

    public void update(Employee employee) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(employee);
        manager.flush();
        transaction.commit();
        manager.close();
    }

    public void remove(Long id) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.createNativeQuery("delete from task_employees where employees_id = ? ")
                .setParameter(1, id)
                .executeUpdate();
        transaction.commit();

        transaction.begin();
        manager.createNativeQuery("delete from employee_occupations where employee_id = ?")
                .setParameter(1, id)
                .executeUpdate();
        transaction.commit();

        transaction.begin();
        manager.createQuery("delete from Employee where id= :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        manager.close();
    }

    public Boolean isPresent(Employee employee) {
        return this.find(employee.getId()) != null;
    }
}
