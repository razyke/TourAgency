package services;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthServiceTest {

    @Test
    public void getSha256Hash() throws Exception {

        String testPassword1 = "5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8";
        String testPassword2 = "8d969eef6ecad3c29a3a629280e686cfc3f5d5a86aff3ca122c923adc6c92";

        assertEquals(testPassword1,AuthService.getSha256Hash("password"));
        assertEquals(testPassword2,AuthService.getSha256Hash("123456"));
    }

}