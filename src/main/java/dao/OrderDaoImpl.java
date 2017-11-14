package dao;

import model.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    private TourDao tourDao;

    public void createOrder(Order order) {
        String SQL = "INSERT INTO orders (tour_id, user_id, price, days, is_activ) VALUES(?,?,?,?)";
        jdbcTemplate.update(SQL, order.getTour().getId(), order.getUser().getId(),
                order.getPrice(), order.getDays(), order.isActiv());
    }

    public Order getOrder(int id) {
        String SQL = "SELECT * FROM orders WHERE id = ?";
        Order order = jdbcTemplate.queryForObject(SQL, new OrderMapper(), id);
        //FIXME: How to set user and tour for order? using UserDao & TourDao?
//        order.setUser(userDao.getUser(order.getUser().getId()));
//        order.setTour(tourDao.getTour(order.getTour().getId(), order.getUser().getLanguage()));
        return order;
    }

    public Collection<Order> getAllOrders() {
        String SQL = "SELECT * FROM orders";
        List<Order> orders = jdbcTemplate.query(SQL, new OrderMapper());
        //FIXME: How to set user and tour for order? using UserDao & TourDao?
//        for (Order order : orders) {
//            order.setUser(userDao.getUser(order.getUser().getId()));
//            order.setTour(tourDao.getTour(order.getTour().getId(), order.getUser().getLanguage()));
//        }
        return orders;
    }

    public void updateOrder(Order order) {
        String SQL = "UPDATE orders SET days = ?, price = ?, is_activ = ? WHERE id = ?";
        jdbcTemplate.update(SQL, order.getDays(), order.getPrice(), order.isActiv(), order.getId());
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

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }
}
