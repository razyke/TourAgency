package services;

import dao.Dao;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private Dao dao;

    /**
     * This method take user that we received from .jsp form
     * We check on validate values and create this user in DB.
     * @param user - received info from .jsp page
     * @param password2 - to check correct input of password
     * @return List of errors, or <code>null</code> if there is no errors.
     */
    public List<String> ValidateAndSend(User user, String password2) {
        //TODO: separate validation from saving to database
        ArrayList<String> errors = new ArrayList<String>();
        boolean error = false;

        //check for empty fields, exception middle name and address

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
            user.setPassword(AuthService.getSha256Hash(user.getPassword()));
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
            int x;
            x = Integer.parseInt(user.getPhone());
        } catch (Exception e) {
            error = true;
            errors.add("Phone contain illegal symbols");
            System.out.println(e.getMessage() + " Cast to int failed.");
        }
        if (user.getEmail().isEmpty() || user.getEmail().equals("")) {
            error = true;
            errors.add("Empty Email");
        } else if (!user.getEmail().contains("@")) {
            error = true;
            errors.add("Wrong naming email");
        }

        if (!error) {
            //Check on unique values in DB
            if (dao.isExist("login", user.getLoginName())) {
                error = true;
                errors.add("This login already used");
            }
            if (dao.isExist("email", user.getEmail())) {
                error = true;
                errors.add("This email already used");
            }
            if (dao.isExist("phone", user.getPhone())) {
                error = true;
                errors.add("This phone already used");
            }
            if (!error) {
                //TODO REMOVE AFTER LANGUAGE
                user.setLanguage("EN");
                dao.createUser(user);
                return null;
            }
        }

        return errors;
    }

    /**
     * This is set via Beans.xml configuration
     * @param dao
     */
    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
