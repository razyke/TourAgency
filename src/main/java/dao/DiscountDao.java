package dao;

import model.Discount;

import javax.sql.DataSource;
import java.util.Collection;

public interface DiscountDao {

    Discount getDiscount(int id);

    Collection<Discount> getAllDiscounts();

    void createDiscount(Discount discount);

    void updateDiscount(Discount discount);

    void deleteDiscount(Discount discount);

    void  setDataSource(DataSource dataSource);
}
