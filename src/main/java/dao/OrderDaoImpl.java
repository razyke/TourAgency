package dao;

import model.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class OrderDaoImpl implements OrderDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void createOrder(Order order) {
        String SQL = "INSERT INTO orders (tour_id, user_id, price, days, is_activ, date) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, order.getTour().getId(), order.getUser().getId(),
                order.getPrice(), order.getDays(), order.isActive(), order.getOrderDate());
    }

    public Order getOrder(int id) {
        String SQL = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new OrderMapper(), id);
    }

    public Collection<Order> getAllOrders() {
        String SQL = "SELECT * FROM orders ORDER BY -is_activ";
        return jdbcTemplate.query(SQL, new OrderMapper());
    }

    public void updateOrder(Order order) {
        String SQL = "UPDATE orders SET days = ?, price = ?, is_activ = ? WHERE id = ?";
        jdbcTemplate.update(SQL, order.getDays(), order.getPrice(), order.isActive(), order.getId());
    }

    public void deleteOrder(int id) {
        String SQL = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
}
