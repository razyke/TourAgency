package services;

import dao.DiscountDao;
import model.Discount;

import java.util.Collection;

public class DiscountsService {

    private DiscountDao dao;

    public Collection<Discount> getAllDiscounts() {
        return dao.getAllDiscounts();
    }

    public Discount getDiscount (int id) {
        return dao.getDiscount(id);
    }
}
