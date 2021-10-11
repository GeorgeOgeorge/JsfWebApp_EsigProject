package dao;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import models.Employee;
import models.Occupation;

@NoArgsConstructor
@Data
public class EmployeeDaoTest {

    private EmployeeDao employeeDao = new EmployeeDao();
    private OccupationDaoTest occupationTest = new OccupationDaoTest();
    private List<Employee> employeesTest = Arrays.asList(
            new Employee(1L,"bruno", (short) 18, "male", true, Arrays.asList(
                    this.occupationTest.getOccupations().get(0))
            ),
            new Employee(2L,"paula", (short) 20, "female", true, Arrays.asList(
                    this.occupationTest.getOccupations().get(1))
            ),
            new Employee(3L,"olga", (short) 22, "female", true, Arrays.asList(
                    this.occupationTest.getOccupations().get(2))
            ),
            new Employee(4L,"carla", (short) 24, "female", true, Arrays.asList(
                    this.occupationTest.getOccupations().get(3))
            ),
            new Employee(5L,"antonio", (short) 67, "male", true, Arrays.asList(
                    this.occupationTest.getOccupations().get(2),
                    this.occupationTest.getOccupations().get(3),
                    this.occupationTest.getOccupations().get(4))
            )
    );

    @Before
    public void beforeEach() {
        this.employeeDao = new EmployeeDao();
    }

    //test insert
    @Test
    public void testA() {
        this.employeesTest.forEach(e -> this.employeeDao.insert(e));
    }

    // test Find
    @Test
    public void testB() {
       Employee employee = this.employeesTest.get(0);
       assertTrue(employee.equals(this.employeeDao.find(employee.getId())));
    }

    // test List
    @Test
    public void testC() {
        this.employeesTest.equals(this.employeeDao.list());
    }

    //test Update
    @Test()
    public void testD() {
        Employee employeeTestUp = new Employee(3L,"bruno", (short) 18, "female", true, Arrays.asList(
                new Occupation(4L, "softEng", true))
        );
        this.employeeDao.update(employeeTestUp);
    }

    //test delete
    @Test
    public void testE() {
        this.employeeDao.remove(this.employeesTest.get(0).getId());
    }


}
