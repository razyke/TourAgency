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
    }

    public void deleteUser(int id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    public void updateUser(User user) {
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
