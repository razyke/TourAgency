package services;

import dao.DiscountDao;
import model.Discount;
import model.Tour;

import java.util.Collection;
import java.util.Date;

public class DiscountService {
    private int hotDiscount;
    private int loyalDiscount;
    private DiscountDao dao;

    public boolean changeValue(int discountId, int newValue, int authorId) {
        if (newValue <= 50 && newValue >= 0) {
            Discount discount = getDiscount(discountId);
            discount.setValue(newValue);
            discount.setAuthorId(authorId);
            discount.setLastUpdate(new Date());
            dao.updateDiscount(discount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Recalculate with discount price in Tour and save discount.
     * @param tour is tour
     * @param isLoyal if current user is loyal
     */
    public void calculateDiscountAndPrice(Tour tour, boolean isLoyal) {
        int discount = tour.isHot() ? hotDiscount : 0;
        discount = isLoyal ? Math.max(discount, loyalDiscount) : discount;
        tour.setDiscount(discount);
        tour.setCostTenDays(
                tour.getCostTenDays() * (100-discount) / 100
        );
        tour.setCostSevenDays(
                tour.getCostSevenDays() * (100-discount) / 100
        );
    }

    /**
     * Load discounts from DB in private fields.
     */
    public void loadDiscounts() {
        Collection<Discount> allDiscounts = dao.getAllDiscounts();
        for (Discount discount : allDiscounts) {
            if (discount.getName().equals("Hot")) {
                hotDiscount = discount.getValue();
            } else if (discount.getName().equals("Loyal")) {
                loyalDiscount = discount.getValue();
            }
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
