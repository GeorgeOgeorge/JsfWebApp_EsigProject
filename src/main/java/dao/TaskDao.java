package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import models.Task;
import util.EntityManagerCreator;

public class TaskDao {
	
	public Task find(Long id) {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		return manager.find(Task.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		return manager.createQuery("select t from Task t order by id")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Task> listStatus(Boolean status) {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		return manager.createQuery("select t from Task t where t.activeStatus= :status order by id")
				.setParameter("status", status)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> listPriority(String priority) {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		return manager.createQuery("select t from Task t where t.priority= :priority order by id")
				.setParameter("priority", priority)
				.getResultList();
	}

	public void insert(Task task) {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(task);
		transaction.commit();
		manager.close();
	}

	public void update(Task task) {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.merge(task);
		transaction.commit();
		manager.close();
	}

	public void remove(Long id) {
		EntityManager manager = EntityManagerCreator.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.createNativeQuery("delete from project_tasks where tasks_id = ? ")
				.setParameter(1,id)
				.executeUpdate();
		transaction.commit();

		transaction.begin();
		manager.createNativeQuery("delete from task_employees where task_id = ? ")
				.setParameter(1,id)
				.executeUpdate();
		transaction.commit();

		transaction.begin();
		manager.createQuery("delete from Task where id= :id")
				.setParameter("id", id)
				.executeUpdate();
		transaction.commit();
		manager.close();
	}

	public Boolean isPresent(Task task) {
		return this.find(task.getId()) != null;
	}
}
