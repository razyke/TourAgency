package services;

import dao.DiscountDao;
import model.Discount;

import java.util.Collection;
import java.util.Date;

public class DiscountService {
    private int hotDiscount;
    private int loyalDiscount;
    private DiscountDao dao;

    public void changeValue(int discountId, int newValue, int authorId) {
        if (newValue <= 50 && newValue >= 0) {
            Discount discount = getDiscount(discountId);
            discount.setValue(newValue);
            discount.setAuthorId(authorId);
            discount.setLastUpdate(new Date());
            dao.updateDiscount(discount);
        } else {
            System.out.println("Wrong discount value!");
        }
    }

    public int calculatePrice(int basePrice, boolean isHot, boolean isLoyal) {
        getAllDiscounts();
        int discount = isHot ? hotDiscount : 0;
        discount = isLoyal ? Math.max(discount, loyalDiscount) : 0;
        return basePrice * (100 - discount) / 100;
    }

    /**
     * Get all discounts from DB.
     * @return Collection of all discounts in DB.
     */
    public Collection<Discount> getAllDiscounts() {
        Collection<Discount> allDiscounts = dao.getAllDiscounts();
        for (Discount discount : allDiscounts) {
            if (discount.getName().equals("Hot")) {
                hotDiscount = Math.max(discount.getValue(), hotDiscount);
            } else if (discount.getName().equals("Loyal")) {
                loyalDiscount = Math.max(discount.getValue(), loyalDiscount);
            }
        }
        return allDiscounts;
    }

    /**
     * Get discount by id in DB.
     * @param id - id of discount in DB.
     * @return discount
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
