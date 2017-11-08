package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoFactory {
    public static Dao getDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        return (Dao) context.getBean("daoImpl");
    }

}
