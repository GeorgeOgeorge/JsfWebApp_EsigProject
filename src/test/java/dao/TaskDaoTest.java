package dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import models.Task;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@NoArgsConstructor
@Data
public class TaskDaoTest {

    private TaskDao taskDao;
    private final EmployeeDaoTest employeeDaoTest = new EmployeeDaoTest();
/*    private List<Task> tasks = Arrays.asList(
            new Task(1L, "program o backEnd", LocalDate.of(2022, 5, 3),
                    "high", true, "program backEnd 3 levels",
                    Arrays.asList(
                            this.employeeDaoTest.getEmployeesTest().get(0),
                            this.employeeDaoTest.getEmployeesTest().get(1)
                    )
            ),
            new Task(2L, "develop the frontEnd", LocalDate.of(2022, 6, 10),
                    "high", true, "develop a responsive frontEnd",
                    Arrays.asList(
                            this.employeeDaoTest.getEmployeesTest().get(2),
                            this.employeeDaoTest.getEmployeesTest().get(3)
                    )
            ),
            new Task(3L, "review the project", LocalDate.of(2022, 7, 3),
                    "high", true, "talk to the client in the scrum meeting",
                    Arrays.asList(
                            this.employeeDaoTest.getEmployeesTest().get(4)
                    )
            )
    );

    @Before
    public void beforeEach() {
        this.taskDao = new TaskDao();
    }

    //test insert
    @Test
    public void testA() {
        this.tasks.forEach(t -> this.taskDao.insert(t));
    }

    // test Find
    @Test
    public void testB() {
        Task task = this.tasks.get(0);
        System.out.println(this.taskDao.find(task.getId()));
        //assertTrue(task.equals(this.taskDao.find(task.getId())));
    }

    // test List
    @Test
    public void testC() {
        System.out.println(this.taskDao.list());
    }

    //test Update
    @Test
    public void testD() {
        Task taskTestUp = new Task(3L, "review do projeto", LocalDate.of(2022, 5, 3),
                "high", true, "falar com o cliente durante o scrum meeting",
                Arrays.asList(
                        this.employeeDaoTest.getEmployeesTest().get(0)
                )
        );
        this.taskDao.update(taskTestUp);
    }

    //test delete
    @Test
    public void testE() {
        this.taskDao.remove(this.tasks.get(0).getId());
    }*/
}
