package services;

import model.User;
import org.junit.Test;
import spring.StaticContextProvider;

import java.util.List;

import static org.junit.Assert.*;

public class AuthServiceTest {

   /* @Test
    public void addAdmin() throws Exception {
        AuthService authService = BeanFactory.getAuthService();
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
        List<String> strings = authService.ValidateAndSend(user,"123456");
        assertEquals(null,strings);
    }*/

    @Test
    public void validateAndSend() throws Exception {

        /*AuthService authService = StaticContextProvider.getAuthService();

        User user = new User();
        user.setLoginName("");
        user.setFirstName("Daniil");
        user.setLastName("Smirnov");
        user.setPassword("123");
        user.setEmail("");
        user.setPhone("erwerwer"); //here error of casting
        //Empty 3 fields
        List<String> strings = authService.ValidateAndSend(user,"123");

        assertEquals(3,strings.size());*/
    }

    @Test
    public void getSha256Hash() throws Exception {

        AuthService service = StaticContextProvider.getAuthService();

        String testPassword1 = "5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8";
        String testPassword2 = "8d969eef6ecad3c29a3a629280e686cfc3f5d5a86aff3ca122c923adc6c92";

        assertEquals(testPassword1,service.getSha256Hash("password"));
        assertEquals(testPassword2,service.getSha256Hash("123456"));
    }

}