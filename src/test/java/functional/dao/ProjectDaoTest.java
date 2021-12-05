package functional.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Project;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@NoArgsConstructor
@Data
public class ProjectDaoTest {
/*
    private ProjectDao projectDao;
    private final TaskDaoTest taskDaoTest = new TaskDaoTest();
    private final Project projectTest = new Project(1L, "sportShop Website", LocalDate.of(2022, 8, 16), true,
            Arrays.asList(
                    this.taskDaoTest.getTasks().get(2)
            )
    );
    private final List<Project> projects = Arrays.asList(
            new Project(1L, "sportShop Website", LocalDate.of(2022, 8, 16), true,
                    Arrays.asList(
                            this.taskDaoTest.getTasks().get(2)
                    )
            ),
            new Project(2L, "candyStore Website", LocalDate.of(2022, 8, 16), true,
                    Arrays.asList(
                            this.taskDaoTest.getTasks().get(0),
                            this.taskDaoTest.getTasks().get(1),
                            this.taskDaoTest.getTasks().get(2)
                    )
            )
    );

    @Before
    public void beforeEach() {
        this.projectDao = new ProjectDao();
    }

    //test insert
    @Test
    public void testA() {
        this.projects.forEach(p -> this.projectDao.insert(p));
    }

    // test Find
    @Test
    public void testB() {
        assertTrue(this.projectTest.equals(this.projectDao.find(this.projectTest.getId())));
    }

    // test List
    @Test
    public void testC() {
        System.out.println(this.projectDao.list());
    }

    //test Update
    @Test
    public void testD() {
        Project projectTest = new Project(1L, "musicShop Website", LocalDate.of(2022, 8, 16), true,
                Arrays.asList(
                        this.taskDaoTest.getTasks().get(1)
                )
        );
        this.projectDao.update(projectTest);
    }

    //test delete
    @Test
    public void testE() {
        this.projectDao.remove(this.projectTest.getId());
    }
*/
}
