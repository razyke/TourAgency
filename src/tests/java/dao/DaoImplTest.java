package dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class DaoImplTest {
    private ApplicationContext context;
    private Dao dao;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("Beans.xml");
        dao = (Dao) context.getBean("Dao");
    }

    @Test
    public void getUser() throws Exception {

    }

}