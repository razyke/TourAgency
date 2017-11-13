package services;

import dao.OrderDao;
import model.Order;
import spring.StaticContextProvider;

import java.util.ArrayList;
import java.util.Collection;

public class OrderService {

    private OrderDao dao;
    private Collection<Order> orders;

    private boolean validateOrder(Order order) {
        //TODO: write this method later
        return true;
    }

    /**
     * Get all orders from DB.
     * @return return orders from DB.
     */
    public Collection<Order> getAllOrders() {
        orders = dao.getAllOrders();
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
        return dao.getOrder(id);
    }

    /**
     * Create order in DB.
     * @param order - that we put in DB.
     */
    public void createOrder(Order order) {
        if (validateOrder(order)){
            dao.createOrder(order);
        } else {
            System.out.println("Invalid order: " + order);
        }
    }

    /**
     * Updating order in DB.
     * @param order that we change.
     */
    public void updateOrder(Order order) {
        dao.updateOrder(order);
    }

    /**
     * Delete order from DB by id.
     * @param id - id of order in DB.
     */
    public void deleteOrder(int id) {
        dao.deleteOrder(id);
    }

    /**
     * For spring mapping
     * @param dao - from Bean.xml
     */
    public void setDao(OrderDao dao) {
        this.dao = dao;
    }
}
