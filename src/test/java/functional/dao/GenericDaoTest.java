package functional.dao;

import dao.GenericDao;
import models.Occupation;
import org.junit.Before;
import org.junit.Test;

public class GenericDaoTest {

    private GenericDao<Occupation, Long> dao;

    @Before
    public void init() {
        this.dao = new GenericDao<>(Occupation.class, Long.class);
    }

    @Test
    public void list() {
        System.out.println(this.dao.list());
    }

    @Test
    public void find() {
        System.out.println(this.dao.find(1L));
    }

    @Test
    public void save() {
        this.dao.save(new Occupation(4L, "mel", true));
    }

    @Test
    public void delete() {
        var x = this.dao.find(28L);
        this.dao.delete(x);
    }

}
