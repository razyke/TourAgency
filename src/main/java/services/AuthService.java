package services;

import dao.UserDao;
import model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AuthService {

    private UserDao dao;

    /**
     * This method take user that we received from .jsp form
     * We check on validate values and create this user in DB.
     * @param user - received info from .jsp page
     * @param password2 - to check correct input of password
     * @return List of errors, or <code>null</code> if there is no errors.
     */
    public List<String> ValidateAndSend(User user, String password2) {

        ArrayList<String> errors = new ArrayList<String>();
        boolean error = false;

        //check for empty fields, exception - middle name and address.

        if (user.getLoginName().isEmpty() || user.getLoginName().equals("")) {
            error = true;
            errors.add("Empty Login Name");
        }

        if (user.getPassword().isEmpty() || user.getPassword().equals("")) {
            error = true;
            errors.add("Empty Password field");
        }
        if (!user.getPassword().equals(password2)) {
            error = true;
            errors.add("Passwords does not repeat");
        } else {
            user.setPassword(getSha256Hash(user.getPassword()));
        }
        if (user.getFirstName().isEmpty() || user.getFirstName().equals("")) {
            error = true;
            errors.add("Empty First Name");
        }
        if (user.getLastName().isEmpty() || user.getLastName().equals("")) {
            error = true;
            errors.add("Empty Last Name");
        }
        if (user.getPhone().isEmpty() || user.getPhone().equals("")) {
            error = true;
            errors.add("Empty Phone");

        }
        try {
            Long.parseLong(user.getPhone());
        } catch (Exception e) {
            error = true;
            errors.add("Phone contain illegal symbols");
        }
        if (user.getEmail().isEmpty() || user.getEmail().equals("")) {
            error = true;
            errors.add("Empty Email");
        } else if (!user.getEmail().contains("@")) {
            error = true;
            errors.add("Wrong naming email");
        }

        if (!error) {
            //Check on unique values in DB.
            if (dao.isLoginUsed(user.getLoginName())) {
                error = true;
                errors.add("This login already used");
            }
            if (dao.isEmailUsed(user.getEmail())) {
                error = true;
                errors.add("This email already used");
            }
            if (dao.isPhoneUsed(user.getPhone())) {
                error = true;
                errors.add("This phone already used");
            }
            if (!error) {
                user.setLanguage("EN"); //TODO: When internationalization service will be completed remove this.
                dao.createUser(user);
                return null;
            }
        }
        return errors;
    }

    /**
     * This method encrypting user/admin password.
     * @param source - not encrypted pass.
     * @return - encrypted pass;
     */
    private String getSha256Hash(String source) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] sourceBytes = source.getBytes();
        md.update(sourceBytes);
        byte[] resultBytes = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (byte current: resultBytes) {
            hexString.append(Integer.toHexString(0xFF & current));
        }
        return hexString.toString();
    }

    /**
     * Trying to find login user and check password.
     * @param userFromJSP - <code>User</code> with sett pass and login name.
     * @return null if not found or incorrect password / <code>User</code> if all correct.
     */
    public User authUser(User userFromJSP) {

        if (userFromJSP.getPassword().isEmpty() ||
                userFromJSP.getLoginName().isEmpty() ||
                userFromJSP.getPassword().equals("") ||
                userFromJSP.getLoginName().equals("")) {
            return null;
        }

        if (dao.isLoginUsed(userFromJSP.getLoginName())) {
            User user = dao.findUser(userFromJSP.getLoginName());
            if (user == null) {
                return null;
            } else {
                if (user.getPassword().equals(getSha256Hash(userFromJSP.getPassword()))) {
                    return user;
                }
                return null;
            }
        }
        return null;
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public Collection<User> getAllUsers() {
        return dao.getAllUsers();
    }
    public boolean isLoyalCustomer(User user) {
        if (user.getLastOrderDate() != null) {
            Date lastOrderDate = user.getLastOrderDate();
            long duration = new Date().getTime() - lastOrderDate.getTime();
            return duration < (long) 183 * 24 * 60 * 60 * 1000;
        } else {
            return false;
        }
    }

    /**
     * Updating user in DB.
     * @param updatedUser - updated info from .jsp page.
     */
    public void updateUser(User updatedUser) {
        dao.updateUser(updatedUser);
    }

    public void updateUserLastOrder(int idUser) {
        User user = dao.getUser(idUser);
        user.setLastOrderDate(new Date());
        updateUser(user);
    }

    /**
     * Change user's role - admin or user
     * @param id user's id
     */
    public void changeUserRole(int id) {
        User user = dao.getUser(id);
        user.setAdmin(!user.isAdmin());
        updateUser(user);
    }

    /**
     * Delete user in DB.
     * @param id - id of user in DB.
     */
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    /**
     * For spring mapping.
     * @param dao - from Bean.xml
     */
    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
