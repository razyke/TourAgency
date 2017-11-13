package dao;

import model.Order;
import model.Tour;
import model.User;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * This class will be work with db.
 * Where we can take/add/create/update/delete values from db.
 */
public interface OrderDao {

    /**
     * This is set via Beans.xml configuration
     * @param dataSource is source of data
     */
    void setDataSource(DataSource dataSource);

    /**
     * Creating order in DB.
     * @param order get this order class from servlet.
     */
    void createOrder(Order order);

    /**
     * Get Order by <code>id</code> from DB.
     * @param id - key of Order.
     * @return order by id from DB.
     */
    Order getOrder(int id);

    /**
     * Get all orders from DB.
     * @return collection of orders.
     */
    Collection<Order> getAllOrders();

    /**
     * Updating order from servlet in DB.
     * @param order - updated order
     */
    void updateOrder(Order order);

    /**
     * Delete Order from DB by <code>id</code>
     * @param id - key of order.
     */
    void deleteOrder(int id);
}
