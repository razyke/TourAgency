package dao;

import model.Tour;
import model.TourMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class TourDaoImpl implements TourDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public Tour getTour(int id, String language) {
        String SQL = "SELECT tours.id, is_hot, title, type, city, description, language, cost_seven, cost_ten " +
                "FROM tours JOIN tour_details ON tours.id = tour_details.tour_id " +
                "WHERE tours.id = ? AND language = ?";
        return jdbcTemplate.queryForObject(SQL, new TourMapper(), id, language);
    }

    @Override
    public Collection<Tour> getAllTours(String language) {
        String SQL = "SELECT tours.id, is_hot, title, type, city, description, language, cost_seven, cost_ten " +
                "FROM tours JOIN tour_details ON tours.id = tour_details.tour_id " +
                "WHERE language = ?";
        return jdbcTemplate.query(SQL, new TourMapper(), language);
    }

    @Override
    public void createTour(Tour tour) {
        String SQL = "INSERT INTO tours (is_hot, cost_seven, cost_ten) VALUES(?,?,?)";
        jdbcTemplate.update(SQL, tour.isHot(), tour.getCostSevenDays(), tour.getCostTenDays());
        SQL = "SELECT max(id) FROM tours";
        tour.setId(jdbcTemplate.queryForObject(SQL, int.class));
        SQL = "INSERT INTO tour_details (tour_id, title, description, language, type, city) " +
                "VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, tour.getId(), tour.getTitle(), tour.getDescription(), "RU",
                tour.getType(), tour.getCity());
        jdbcTemplate.update(SQL, tour.getId(), tour.getTitle(),
                tour.getDescription(), "EN", tour.getType(), tour.getCity());
    }

    @Override
    public void deleteTour(int id) {
        String SQL = "DELETE FROM tours WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateTour(Tour tour) {
        String SQL = "UPDATE tours SET is_hot = ?, cost_seven = ?, cost_ten = ? WHERE id = ?";
        jdbcTemplate.update(SQL, tour.isHot(), tour.getCostSevenDays(), tour.getCostTenDays(), tour.getId());
        SQL = "UPDATE tour_details SET title = ?, description = ?, type = ?, city = ? " +
                "WHERE tour_id = ? AND language = ?";
        jdbcTemplate.update(SQL, tour.getTitle(), tour.getDescription(),tour.getType(), tour.getCity(),
                tour.getId(), tour.getLanguage());
    }

    @Override
    public boolean isTitleUsed(String title) {
        String SQL = "SELECT count(id)>0 FROM tour_details WHERE title = ?";
        return jdbcTemplate.queryForObject(SQL, boolean.class, title);
    }
}
