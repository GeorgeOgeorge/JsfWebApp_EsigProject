package dao;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import models.Occupation;

@NoArgsConstructor
@Data
public class OccupationDaoTest {

    private OccupationDao occupationDao ;
    private List<Occupation> occupations = Arrays.asList(
            new Occupation(1L, "devFront", true),
            new Occupation(2L, "devBack", true),
            new Occupation(3L, "devFullstack", true),
            new Occupation(4L, "SoftEng", true),
            new Occupation(5L, "Manager", true)
    );

    @Before
    public void BeforeEach() {
        occupationDao = new OccupationDao();
    }

    //test insert
    @Test
    public void testA() {
        this.occupations.forEach(o -> this.occupationDao.insert(o));
    }

    // test Find
    @Test
    public void testB() {
        Occupation occupation = this.occupations.get(0);
        assertTrue(occupation.equals(this.occupationDao.find(occupation.getId())));
    }

    // test List
    @Test
    public void testC() {
        System.out.println(this.occupationDao.list());
    }


    //test Update
    @Test
    public void testD() {
        Occupation occupationTest = new Occupation(3L, "NetworkManager", true);
        assertTrue("update", occupationTest.equals(this.occupationDao.update(occupationTest)));
    }

    //test delete
    @Test
    public void testE() {
        this.occupationDao.remove(this.occupations.get(0).getId());
    }


}
