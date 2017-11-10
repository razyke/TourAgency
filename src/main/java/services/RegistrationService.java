package services;

import dao.BeanFactory;
import dao.Dao;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    //private final Dao dao;

    public RegistrationService() {
        //dao = BeanFactory.getDao();
        //TODO get factory bean of service
    }

    /**
     * This method take user that we received from .jsp form
     * We check on validate values and create this user in DB.
     * @param user - received info from .jsp page
     * @param password2 - to check correct input of password
     * @return List of errors, or <code>null</code> if there is no errors.
     */
    public List<String> ValidateAndSend(User user, String password2){

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
            //TODO check on parse int
        }
        if (user.getEmail().isEmpty() || user.getEmail().equals("")) {
            error = true;
            errors.add("Empty Email");
        } else if (!user.getEmail().contains("@")) {
            error = true;
            errors.add("Wrong naming email");
        }

        //TODO Add check on unique fields LOGIN NAME, PHONE, EMAIL + add language in User

        if (!error) {
            //For test commented this 2 lines.
            //dao.createUser(user);
            return null;
        } else {
            return errors;
        }
    }

}
