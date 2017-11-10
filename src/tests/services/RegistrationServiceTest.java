package services;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegistrationServiceTest {

    @Test
    public void validateAndSend() throws Exception {
        RegistrationService registrationService = new RegistrationService();

        String[] userStrings = new String[9];
        userStrings[0] = "Daniil";  // First name
        userStrings[1] = null;      // Middle name
        userStrings[2] = "Smirnov"; // Last name
        userStrings[3] = "dsmir@mail.ru"; //Email
        userStrings[4] = "7823132123"; //Phone number
        userStrings[5] = null; //Address
        userStrings[6] = "superman"; //login name
        userStrings[7] = "123123"; //password
        userStrings[8] = "123123"; //password 2

       // List<String> strings = registrationService.ValidateAndSend(userStrings);

        //assertEquals(null,strings);
    }

}