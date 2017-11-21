package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Discount discount = new Discount();
        discount.setId(resultSet.getInt("id"));
        discount.setName(resultSet.getString("name"));
        discount.setValue(resultSet.getInt("value"));
        discount.setAuthorId(resultSet.getInt("author_id"));
        discount.setLastUpdate(resultSet.getDate("last_update"));
        return discount;
    }
}
