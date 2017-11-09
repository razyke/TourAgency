package dao;

import model.Tour;
import model.User;

import java.util.Collection;

/**
 * This class will be work with db.
 * Where we can take/add/create/update/delete values from db.
 */
public interface Dao {

    /**
     * This method get User from DB by <code>id</code>.
     * @param id - user id
     * @return user by id from DB.
     */
    User getUser(int id);

    /**
     * This method return collection of users.
     * @return all users that was in DB.
     */
    Collection<User> getAllUsers();

    /**
     * This method create user in DB.
     * @param user we send user from jsp form.
     */
    void createUser(User user);

    /**
     * This method return User with set fields user.login and user.password
     * @param loginName - parameter that we will try to find in DB
     * @return User with fields user.
     */
    User findUser(String loginName);

    /**
     * Delete user by <code>id</code>.
     * @param id - key of user.
     */
    void deleteUser(int id);

    /**
     * Updating user in DB.
     * @param user - updated user.
     */
    void updateUser(User user);

    /**
     * Check if the user with a given value of given field
     * @param columnName is name of field
     * @param value is value to check
     * @return
     */
    boolean isExist(String columnName, String value);

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

}
