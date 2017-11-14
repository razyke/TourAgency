package dao;

import model.Discount;
import model.DiscountMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class DiscountDaoImpl implements DiscountDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public Discount getDiscount(int id) {

        String SQL = "SELECT * FROM discounts WHERE id = ?";
        return (Discount) jdbcTemplate.query(SQL, new DiscountMapper(), id);
    }

    @Override
    public Collection<Discount> getAllDiscounts() {
        String SQL = "SELECT * FROM discounts";
        return jdbcTemplate.query(SQL, new DiscountMapper());
    }

    @Override
    public void createDiscount(Discount discount) {
        String SQL = "INSERT INTO discounts (name, value, author_id) VALUES(?,?,?)";
        jdbcTemplate.update(SQL, discount.getName(), discount.getValue(), discount.getAuthorId());
    }

    @Override
    public void updateDiscount(Discount discount) {
        String SQL = "UPDATE discounts SET name = ?, value = ?, author_id = ? WHERE id = ?";
        jdbcTemplate.update(SQL, discount.getName(), discount.getValue(), discount.getAuthorId(), discount.getId());
    }

    @Override
    public void deleteDiscount(Discount discount) {
        String SQL = "DELETE FROM discounts WHERE id = ?";
        jdbcTemplate.update(SQL, discount.getId());
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
}
