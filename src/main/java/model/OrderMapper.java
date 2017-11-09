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
        return order;
    }
}
