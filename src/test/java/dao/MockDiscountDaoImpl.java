package dao;

import model.Discount;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockDiscountDaoImpl implements DiscountDao {
    private final Map<Integer, Discount> discounts;

    {
        discounts = new HashMap<Integer, Discount>();
        Discount discount1 = new Discount();
        discount1.setId(1);
        discount1.setName("Loyal");
        discount1.setValue(10);
        discount1.setAuthorId(18);
        discounts.put(1, discount1);
        Discount discount2 = new Discount();
        discount2.setAuthorId(18);
        discount2.setValue(20);
        discount2.setName("Hot");
        discount2.setId(2);
        discounts.put(2,discount2);
    }

    @Override
    public Discount getDiscount(int id) {
        return discounts.get(id);
    }

    @Override
    public Collection<Discount> getAllDiscounts() {
        return discounts.values();
    }

    @Override
    public void createDiscount(Discount discount) {
        discounts.put(discount.getId(), discount);
    }

    @Override
    public void updateDiscount(Discount discount) {
        discounts.put(discount.getId(), discount);
    }

    @Override
    public void deleteDiscount(Discount discount) {
        discounts.remove(discount.getId());
    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
