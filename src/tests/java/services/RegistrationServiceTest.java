package services;

import dao.BeanFactory;
import model.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegistrationServiceTest {
    @Test
    public void addAdmin() throws Exception {

        RegistrationService registrationService = BeanFactory.getRegistrationService();

        User user = new User();
        user.setLoginName("razyke");
        user.setFirstName("Daniil");
        user.setLastName("Smirnov");
        user.setMiddleName("Victorovich");
        user.setPassword("123456");
        user.setEmail("ds@epam.com");
        user.setPhone("1122333"); //here error of casting
        user.setAdmin(true);

        //Empty 3 fields
        List<String> strings = registrationService.ValidateAndSend(user,"123456");
        assertEquals(null,strings);
    }

    @Test
    public void validateAndSend() throws Exception {

        RegistrationService registrationService = BeanFactory.getRegistrationService();

        User user = new User();
        user.setLoginName("");
        user.setFirstName("Daniil");
        user.setLastName("Smirnov");
        user.setPassword("123");
        user.setEmail("");
        user.setPhone("erwerwer"); //here error of casting
        //Empty 3 fields


       List<String> strings = registrationService.ValidateAndSend(user,"123");

       assertEquals(3,strings.size());
    }

}