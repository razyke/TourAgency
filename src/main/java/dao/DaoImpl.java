package dao;

import model.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

public class DaoImpl implements Dao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /**
     * This is set via Beans.xml configuration
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUser(int id) {
        String SQL = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new UserMapper());
    }

    public Collection<User> getAllUsers() {
        String SQL = "SELECT * FROM users";
        return jdbcTemplate.query(SQL, new UserMapper());
    }

    public void createUser(User user) {
        String SQL = "INSERT INTO users (login, password, first_name, middle_name, last_name, is_admin, " +
                "phone, address, last_order_date, email, language) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, user.getLoginName(), user.getPassword(), user.getFirstName(),
                user.getMiddleName(), user.getLastName(), user.isAdmin(), user.getPhone(),
                user.getAddress(), user.getLastOrderDate(), user.getEmail(), user.getLanguage());
    }

    public User findUser(String loginName) {
        String SQL = "SELECT * FROM users WHERE login = ?";
        return jdbcTemplate.queryForObject(SQL, new UserMapper(), loginName);
    }

    public void deleteUser(int id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    public void updateUser(User user) {
        String SQL = "UPDATE users SET login = ?, password = ?, first_name = ?, middle_name = ?, last_name = ?, " +
                "is_admin = ?, phone = ?, address = ?, last_order_date = ?, email = ?, language = ?) WHERE id = ?";
        jdbcTemplate.update(SQL, user.getLoginName(), user.getPassword(), user.getFirstName(), user.getMiddleName(),
                user.getLastName(), user.isAdmin(), user.getPhone(),user.getAddress(), user.getLastOrderDate(),
                user.getEmail(), user.getLanguage(), user.getId());
    }

    public boolean isExist(String from, String columnName, String value) {
        String SQL = "SELECT count(id)>0 FROM" + from +" WHERE " + columnName + " = ?";
        return jdbcTemplate.queryForObject(SQL, boolean.class, value);
    }

    public boolean isExist(String columnName, String value) {
        return isExist("users", columnName, value);
    }

    public Tour getTour(int id, String language) {
        String SQL = "SELECT tours.id, is_hot, title, type, city, description, language, cost_seven, cost_ten " +
                "FROM tours JOIN tour_details ON tours.id = tour_details.tour_id " +
                "WHERE tours.id = ? AND language = ?";
        return jdbcTemplate.queryForObject(SQL, new TourMapper(), id, language);
    }

    public Collection<Tour> getAllTours(String language) {
        String SQL = "SELECT tours.id, is_hot, title, type, city, description, language, cost_seven, cost_ten " +
                "FROM tours JOIN tour_details ON tours.id = tour_details.tour_id " +
                "WHERE language = ?";
        return jdbcTemplate.query(SQL, new TourMapper(), language);
    }

    public void createTour(Tour tour) {
        String SQL = "INSERT INTO tours (is_hot) VALUES(?)";
        jdbcTemplate.update(SQL, tour.isHot());
        SQL = "INSERT INTO tour_details (tour_id, title, description, language, type, city, cost_seven, cost_ten) " +
                "VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, tour.getId(), tour.getTitle(), tour.getDescription(), tour.getLanguage(),
                tour.getType(), tour.getCity(), tour.getCostSevenDays(), tour.getCostTenDays());
    }

    public void deleteTour(int id) {
        String SQL = "DELETE FROM tours WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    public void updateTour(Tour tour) {
        String SQL = "UPDATE tours SET is_hot = ?, cost_seven = ?, cost_ten = ? WHERE id = ?";
        jdbcTemplate.update(SQL, tour.isHot(), tour.getCostSevenDays(), tour.getCostTenDays(), tour.getId());
        SQL = "UPDATE tour_details SET title = ?, description = ?, type = ?, city = ? " +
                "WHERE tour_id = ? AND language = ?";
        jdbcTemplate.update(SQL, tour.getTitle(), tour.getDescription(),tour.getType(), tour.getCity(),
                tour.getId(), tour.getLanguage());
    }

    public void createOrder(Order order) {
        String SQL = "INSERT INTO orders (tour_id, user_id, price, days, is_activ) VALUES(?,?,?,?)";
        jdbcTemplate.update(SQL, order.getTour().getId(), order.getUser().getId(),
                order.getPrice(), order.getDays(), order.isActiv());
    }

    public Order getOrder(int id) {
        String SQL = "SELECT * FROM orders WHERE id = ?";
        Order order = jdbcTemplate.queryForObject(SQL, new OrderMapper(), id);
        order.setUser(getUser(order.getUser().getId()));
        order.setTour(getTour(order.getTour().getId(), order.getUser().getLanguage()));
        return order;
    }

    public Collection<Order> getAllOrders() {
        String SQL = "SELECT * FROM orders";
        List<Order> orders = jdbcTemplate.query(SQL, new OrderMapper());
        for (Order order : orders) {
            order.setUser(getUser(order.getUser().getId()));
            order.setTour(getTour(order.getTour().getId(), order.getUser().getLanguage()));
        }
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
}
