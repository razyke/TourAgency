package dao;

import model.Discount;

import java.util.Collection;

public interface DiscountDao {

    Discount getDiscount(int id);

    Collection<Discount> getAllDiscounts();


}
