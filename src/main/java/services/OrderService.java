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
    public Collection<Order> getAllOrders() {
        orders = dao.getAllOrders();
        return orders;
    }

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

    public void createOrder(Order order) {
        if (validateOrder(order)){
            dao.createOrder(order);
        } else {
            System.out.println("Invalid order: " + order);
        }
    }

    public void updateOrder(Order order) {
        dao.updateOrder(order);
    }

    public void deleteOrder(Order order) {
        dao.deleteOrder(order.getId());
    }

    public void setDao(OrderDao dao) {
        this.dao = dao;
    }
}
