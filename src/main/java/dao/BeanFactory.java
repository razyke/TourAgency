package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.RegistrationService;

public class BeanFactory {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("Beans.xml");

    public static Dao getDao() {
        return (Dao) CONTEXT.getBean("Dao");
    }

    public static RegistrationService getRegistrationService() {
        return (RegistrationService) CONTEXT.getBean("RegistrationService");
    }
}
