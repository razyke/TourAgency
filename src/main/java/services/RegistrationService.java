package services;

import dao.BeanFactory;
import dao.Dao;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private final Dao dao;

    public RegistrationService() {
        dao = BeanFactory.getDao();
    }

    /**
     * This method take array of string that we received from .jsp form
     * We check on validate values and create this user in DB.
     * @param userStrings - received info from .jsp page
     * @return List of errors, or <code>null</code> if there is no errors.
     */
    public List<String> ValidateAndSend(String[] userStrings){

        ArrayList<String> errors = new ArrayList<String>();
        boolean error = false;

        //check for empty fields, exception middle name and address
        for (int i = 0; i < userStrings.length; i++) {
            if (i == 1 || i == 5) {
                continue;
            }
            if (userStrings[i].isEmpty() || userStrings[i].equals("")) {
                errors.add("Field is empty - " + userStrings[i]);
                error = true;
            }
        }

        //check passwords correct
        if (!userStrings[7].equals(userStrings[8])) {
            errors.add("Passwords does not repeat");
            error = true;
        }

        //if email contain @
        if (!userStrings[3].contains("@")){
            error = true;
        }

        //TODO Add check on unique fields LOGIN NAME, PHONE, EMAIL + add language in User

        if (!error) {
            User user = new User();
            user.setFirstName(userStrings[0]);
            user.setMiddleName(userStrings[1]);
            user.setLastName(userStrings[2]);
            user.setEmail(userStrings[3]);
            user.setPhone(userStrings[4]);
            user.setAddress(userStrings[5]);
            user.setLoginName(userStrings[6]);
            user.setPassword(AuthService.getSha256Hash(userStrings[7]));

            //For test commented this 2 lines.
            //dao.createUser(user);
            return null;

            } else {

            return errors;
        }

    }
}
