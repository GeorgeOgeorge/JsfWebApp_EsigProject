package functional.utilTest;
import javax.persistence.EntityManager;

import org.junit.Test;

import util.EntityManagerCreator;

public class EntityCreatorTest {

    @Test
    public void createFactory() {
    	EntityManager manager = EntityManagerCreator.getEntityManager();
    	manager.close();
    }
}
