package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.AuthService;

public class BeanFactory {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("Beans.xml");

    public static Dao getDao() {
        return (Dao) CONTEXT.getBean("Dao");
    }

    public static AuthService getAuthService() {
        return (AuthService) CONTEXT.getBean("authService");
    }
}
