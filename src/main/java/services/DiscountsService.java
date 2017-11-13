package services;

import dao.DiscountDao;
import model.Discount;

import java.util.Collection;

public class DiscountsService {

    private DiscountDao dao;

    /**
     * Get all discounts from DB.
     * @return Collection of all discounts in DB.
     */
    public Collection<Discount> getAllDiscounts() {
        return dao.getAllDiscounts();
    }

    /**
     * Get discount by id in DB.
     * @param id - id of discount in DB.
     * @return
     */
    public Discount getDiscount (int id) {
        return dao.getDiscount(id);
    }

    /**
     * For spring mapping
     * @param dao - from Bean.xml
     */
    public void setDao(DiscountDao dao) {
        this.dao = dao;
    }
}
