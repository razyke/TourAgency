package dao;

import model.User;
import model.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class UserDaoImpl implements UserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(int id) {
        String SQL = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new UserMapper());
    }

    @Override
    public Collection<User> getAllUsers() {
        String SQL = "SELECT * FROM users";
        return jdbcTemplate.query(SQL, new UserMapper());
    }

    @Override
    public void createUser(User user) {
        String SQL = "INSERT INTO users (login, password, first_name, middle_name, last_name, is_admin, " +
                "phone, address, last_order_date, email, language) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, user.getLoginName(), user.getPassword(), user.getFirstName(),
                user.getMiddleName(), user.getLastName(), user.isAdmin(), user.getPhone(),
                user.getAddress(), user.getLastOrderDate(), user.getEmail(), user.getLanguage());
    }

    @Override
    public User findUser(String loginName) {
        String SQL = "SELECT * FROM users WHERE login = ?";
        return jdbcTemplate.queryForObject(SQL, new UserMapper(), loginName);
    }

    @Override
    public void deleteUser(int id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateUser(User user) {
        String SQL = "UPDATE users SET login = ?, password = ?, first_name = ?, middle_name = ?, last_name = ?, " +
                "is_admin = ?, phone = ?, address = ?, last_order_date = ?, email = ?, language = ? WHERE id = ?";
        jdbcTemplate.update(SQL, user.getLoginName(), user.getPassword(), user.getFirstName(), user.getMiddleName(),
                user.getLastName(), user.isAdmin(), user.getPhone(),user.getAddress(), user.getLastOrderDate(),
                user.getEmail(), user.getLanguage(), user.getId());
    }

    @Override
    public boolean isLoginUsed(String login) {
        String SQL = "SELECT count(id)>0 FROM users WHERE login = ?";
        return jdbcTemplate.queryForObject(SQL, boolean.class, login);
    }

    @Override
    public boolean isEmailUsed(String email) {
        String SQL = "SELECT count(id)>0 FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(SQL, boolean.class, email);
    }

    @Override
    public boolean isPhoneUsed(String phone) {
        String SQL = "SELECT count(id)>0 FROM users WHERE phone = ?";
        return jdbcTemplate.queryForObject(SQL, boolean.class, phone);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
}
