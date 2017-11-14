package services;

import dao.OrderDao;
import dao.TourDao;
import dao.UserDao;
import model.Order;
import spring.StaticContextProvider;

import java.util.Collection;

public class OrderService {

    private OrderDao orderDao;
    private TourDao tourDao;
    private UserDao userDao;

    private Collection<Order> orders;

    public static void main(String[] args) {
        OrderService orderService = StaticContextProvider.getOrderService();
        orderService.getAllOrders();
        System.out.println();

    }

    private boolean validateOrder(Order order) {
        //TODO: write this method later
        return true;
    }

    /**
     * Get all orders from DB.
     * @return return orders from DB.
     */
    public Collection<Order> getAllOrders() {
        orders = orderDao.getAllOrders();
        for (Order order : orders) {
            order.setUser(userDao.getUser(order.getUser().getId()));
            order.setTour(tourDao.getTour(order.getTour().getId(), order.getUser().getLanguage()));
        }
        return orders;
    }

    /**
     * Get order by id from DB.
     * @param id of order from DB.
     * @return order from DB.
     */
    public Order getOrder(int id) {
        if (orders != null) {
            for (Order order : orders) {
                if (order.getId() == id) {
                    return order;
                }
            }
        }
        Order order = orderDao.getOrder(id);
        order.setUser(userDao.getUser(order.getUser().getId()));
        order.setTour(tourDao.getTour(order.getTour().getId(), order.getUser().getLanguage()));
        return order;
    }

    /**
     * Create order in DB.
     * @param order - that we put in DB.
     */
    public void createOrder(Order order) {
        if (validateOrder(order)){
            orderDao.createOrder(order);
        } else {
            System.out.println("Invalid order: " + order);
        }
    }

    /**
     * Updating order in DB.
     * @param order that we change.
     */
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    /**
     * Delete order from DB by id.
     * @param id - id of order in DB.
     */
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    /**
     * For spring mapping
     * @param orderDao - from Bean.xml
     */
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * For spring mapping
     * @param tourDao - from Bean.xml
     */
    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    /**
     * For spring mapping
     * @param userDao - from Bean.xml
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
