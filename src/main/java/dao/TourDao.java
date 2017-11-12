package dao;

import model.Order;
import model.Tour;
import model.User;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * This class will be work with db.
 * Where we can take/add/create/update/delete tours from db.
 */
public interface TourDao {

    /**
     * This is set via Beans.xml configuration
     * @param dataSource is source of data
     */
    void setDataSource(DataSource dataSource);

    /**
     * Get Tour by <code>id</code> from DB.
     * @param id - key of Tour.
     * @param language - selected language of page.
     * @return tour by id from DB.
     */
    Tour getTour(int id, String language);

    /**
     * Get all tours from DB.
     * @param language - selected language of page.
     * @return collection of tours.
     */
    Collection<Tour> getAllTours(String language);

    /**
     * Creating tour in DB.
     * @param tour get this tour class from servlet.
     */
    void createTour(Tour tour);

    /**
     * Delete Tour from DB by <code>id</code>
     * @param id - key of Tour.
     */
    void deleteTour(int id);

    /**
     * Updating tour from servlet in DB.
     * @param tour - updated tour
     */
    void updateTour(Tour tour);

    /**
     * Check is there Tour with a given title.
     * @param title is title to check
     * @return if title is used
     */
    boolean isTitleUsed(String title);
}
