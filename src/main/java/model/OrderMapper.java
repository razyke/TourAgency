package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setPrice(resultSet.getInt("price"));
        order.setDays(resultSet.getInt("days"));
        order.setActiv(resultSet.getBoolean("is_activ"));
        order.setUser(new User());
        order.getUser().setId(resultSet.getInt("user_id"));
        order.setTour(new Tour());
        order.getTour().setId(resultSet.getInt("tour_id"));
        order.setOrderDate(resultSet.getDate("date"));

        return order;
    }
}
