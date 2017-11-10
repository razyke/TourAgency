package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setMiddleName(resultSet.getString("middle_name"));
        user.setLoginName(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setPhone(resultSet.getString("phone"));
        user.setAddress(resultSet.getString("address"));
        user.setAdmin(resultSet.getBoolean("is_admin"));
        user.setLastOrderDate(resultSet.getDate("last_order_date"));
        user.setEmail(resultSet.getString("email"));
        user.setLanguage(resultSet.getString("language"));
        return user;

    }
}
