package spring;

import dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.AuthService;

/**
 * It's required _only_ for servlets,
 * everywhere else beans should be initialized via Beans.xml
 */
public class StaticContextProvider {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("Beans.xml");

    public static Dao getDao() {
        return (Dao) CONTEXT.getBean("Dao");
    }

    public static AuthService getAuthService() {
        return (AuthService) CONTEXT.getBean("authService");
    }
}
