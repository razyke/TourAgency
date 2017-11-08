package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourMapper implements RowMapper<Tour> {

    public Tour mapRow(ResultSet resultSet, int i) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getInt("id"));
        tour.setHot(resultSet.getBoolean("is_hot"));
        return null;
    }
}
