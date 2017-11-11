package dao;

import model.User;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * This class will be work with db.
 * Where we can take/add/create/update/delete users from db.
 */
public interface UserDao {

    /**
     * This is set via Beans.xml configuration
     * @param dataSource is source of data
     */
    void setDataSource(DataSource dataSource);

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
     * Check is there User with a given login.
     * @param login is login to check
     * @return if exist user with a given login
     */
    boolean isLoginUsed(String login);

    /**
     * Check is there User with a given email.
     * @param email is email to check
     * @return if exist user with a given email
     */
    boolean isEmailUsed(String email);

    /**
     * Check is there User with a given phone.
     * @param phone is phone to check
     * @return if exist user with a given phone
     */
    boolean isPhoneUsed(String phone);
}
