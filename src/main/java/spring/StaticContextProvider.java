package spring;

import dao.TourDao;
import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.AuthService;

/**
 * It's required _only_ for servlets,
 * everywhere else beans should be initialized via Beans.xml
 */
public class StaticContextProvider {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("Beans.xml");

    public static UserDao getUserDao() {
        return (UserDao) CONTEXT.getBean("UserDao");
    }

    public static TourDao getTourDao() {
        return (TourDao) CONTEXT.getBean("TourDao");
    }

    public static AuthService getAuthService() {
        return (AuthService) CONTEXT.getBean("authService");
    }
}
