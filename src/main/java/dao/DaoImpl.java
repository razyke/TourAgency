package dao;

import model.Tour;
import model.TourMapper;
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
}
