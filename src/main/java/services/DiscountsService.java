package services;

import dao.DiscountDao;
import model.Discount;

import java.util.Collection;
import java.util.Date;

public class DiscountsService {

    private DiscountDao dao;

    public void changeValue(int discountId, int newValue, int authorId) {
        if (discountId <= 50 && discountId >= 0) {
            Discount discount = getDiscount(discountId);
            discount.setValue(newValue);
            discount.setAuthorId(authorId);
            discount.setLastUpdate(new Date());
            dao.updateDiscount(discount);
        } else {
            System.out.println("Wrong discount value!");
        }
    }
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
