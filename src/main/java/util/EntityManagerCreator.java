package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {
    private static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("TaskManagerPU");

    public static EntityManager getEntityManager() {
        return managerFactory.createEntityManager();
    }
}
