package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.AuthService;
import services.DiscountService;
import services.OrderService;
import services.TourService;

/**
 * It's required _only_ for servlets,
 * everywhere else beans should be initialized via Beans.xml
 */
public class StaticContextProvider {

    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("Beans.xml");

    public static AuthService getAuthService() {
        return (AuthService) CONTEXT.getBean("authService");
    }

    public static TourService getTourService() {
        return (TourService) CONTEXT.getBean("tourService");
    }

    public static OrderService getOrderService() {
        return (OrderService) CONTEXT.getBean("orderService");
    }

    public static DiscountService getDiscountService() {
        return (DiscountService) CONTEXT.getBean("discountService");
    }
}
