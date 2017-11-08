package dao;

import model.Tour;
import model.User;
import model.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class DaoImpl implements Dao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

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
        String SQL = "INSERT INTO user (login, password, first_name, middle_name, last_name, is_admin, " +
                "phone, address, last_order_date) VALUES (?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, user.getLoginName(), user.getPassword(), user.getFirstName(),
                user.getMiddleName(), user.getLastName(), user.isAdmin(), user.getPhone(),
                user.getAddress(), user.getLastOrderDate());
    }

    public void deleteUser(int id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    public void updateUser(User user) {
        String SQL = "UPDATE user SET login = ?, password = ?, first_name = ?, middle_name = ?, last_name = ?, is_admin = ?, " +
                "phone = ?, address = ?, last_order_date = ?) WHERE id = ?";
        jdbcTemplate.update(SQL, user.getLoginName(), user.getPassword(), user.getFirstName(),
                user.getMiddleName(), user.getLastName(), user.isAdmin(), user.getPhone(),
                user.getAddress(), user.getLastOrderDate(), user.getId());
    }

    public Tour getTour(int id) {
        return null;
    }

    public Collection<Tour> getAllTours() {
        return null;
    }

    public void createTour(Tour tour) {

    }

    public void deleteTour(int id) {

    }

    public void updateTour(Tour tour) {

    }
}
