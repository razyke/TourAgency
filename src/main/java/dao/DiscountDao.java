package dao;

import model.Discount;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * This class will be work with DB.
 * Where we can take/add/create/update/delete values from DB.
 */
public interface DiscountDao {

    /**
     * Return <code>Discount</code> by param <code>id</code>.
     * @param id - of discount
     * @return obj discount from DB.
     */
    Discount getDiscount(int id);

    /**
     * Return all <code>Discounts</code> that we have in DB.
     * @return
     */
    Collection<Discount> getAllDiscounts();

    /**
     * Create new discount in DB.
     * @param discount object that we put in DB.
     */
    void createDiscount(Discount discount);

    /**
     * Updating already existing discount.
     * @param discount object that we update in DB.
     */
    void updateDiscount(Discount discount);

    /**
     * Deleting discount from DB.
     * @param discount object that we delete.
     */
    void deleteDiscount(Discount discount);

    /**
     * This is set via Beans.xml configuration.
     * @param dataSource is source of data
     */
    void  setDataSource(DataSource dataSource);
}
