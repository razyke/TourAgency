package services;

import model.User;
import org.junit.Test;
import spring.StaticContextProvider;

import java.util.List;

import static org.junit.Assert.*;

public class AuthServiceTest {

    @Test
    public void addAdmin() throws Exception {

        AuthService authService = StaticContextProvider.getAuthService();

        User user = new User();
        user.setLoginName("admin");
        user.setFirstName("Ivan");
        user.setLastName("Urievich");
        user.setMiddleName("Dobruh");
        user.setPassword("123456");
        user.setEmail("IUD@epam.com");
        user.setPhone("11112");
        user.setLanguage("EN");
        user.setAdmin(true);

        List<String> strings = authService.ValidateAndSend(user,"123456");
        assertEquals(null,strings);
    }

    @Test
    public void validateAndSend() throws Exception {

        AuthService authService = StaticContextProvider.getAuthService();

        User user = new User();
        user.setLoginName("");
        user.setFirstName("Eric");
        user.setLastName("Cartman");
        user.setPassword("123");
        user.setEmail("");
        user.setLanguage("EN");
        user.setPhone("suckmywalls"); //here error of casting
        List<String> errorStrings = authService.ValidateAndSend(user,"123");

        assertEquals(3,errorStrings.size());
    }

    @Test
    public void validateAndSend2() throws Exception {

        AuthService authService = StaticContextProvider.getAuthService();

        User user = new User();

        user.setLoginName("virmaster");
        user.setFirstName("Valentain");
        user.setMiddleName("Pamaunt");
        user.setLastName("Vimpelman");
        user.setPassword("iamcool777");
        user.setEmail("vpv@emam.com");
        user.setPhone("5523232");
        user.setLanguage("EN");

        List<String> errorStrings = authService.ValidateAndSend(user, "iamcool777");

        assertEquals(null, errorStrings);
    }

    @Test
    public void login() throws Exception {

        AuthService service = StaticContextProvider.getAuthService();

        User user1 = new User("razyke","123456");
        User user2 = new User("User1", "password");

        User authUser1 = service.authUser(user1);
        User authUser2 = service.authUser(user2);
        boolean error = true;

        if (authUser1 != null && authUser2 != null) {
            error = false;
        }

        assertTrue(!error);
    }

}