package services;

import dao.OrderDao;
import dao.TourDao;
import dao.UserDao;
import lombok.extern.log4j.Log4j;
import model.Order;
import model.Tour;
import model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Log4j

public class OrderService {

    private OrderDao orderDao;
    private TourDao tourDao;
    private UserDao userDao;

    private Collection<Order> orders;

    private boolean validateOrder(Order order) {
        if (order.getOrderDate().after(new Date()))
        {
            return true;
        }
        return false;
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

    public Collection<Order> getAllOrders(int userId) {
        getAllOrders();
        Collection<Order> ordersFromUser = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.getUser().getId() == userId) {
                ordersFromUser.add(order);
            }
        }
        return ordersFromUser;
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
    public boolean createOrder(Order order, int userId, int tourId) {
        User user = userDao.getUser(userId);
        Tour tour = new Tour();
        tour.setId(tourId);
        order.setUser(user);
        order.setTour(tour);
        if (validateOrder(order)){
            orderDao.createOrder(order);
            return true;
        } else {
            log.error("Error to create order");
            return false;
        }
    }

    /**
     * Marks the order inactive.
     * @param id - id of tour
     */
    public void acceptOrder(int id) {
        Order order = getOrder(id);
        order.setActive(false);
        updateOrder(order);
        order.getUser().setLastOrderDate(new Date());
        userDao.updateUser(order.getUser());
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
