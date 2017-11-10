package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourMapper implements RowMapper<Tour> {

    public Tour mapRow(ResultSet resultSet, int i) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getInt("id"));
        tour.setHot(resultSet.getBoolean("is_hot"));
        tour.setTitle(resultSet.getString("title"));
        tour.setType(resultSet.getString("type"));
        tour.setCity(resultSet.getString("city"));
        tour.setDescription(resultSet.getString("description"));
        tour.setLanguage(resultSet.getString("language"));
        tour.setCostSevenDays(resultSet.getInt("cost_seven"));
        tour.setCostTenDays(resultSet.getInt("cost_ten"));
        return tour;
    }
}
