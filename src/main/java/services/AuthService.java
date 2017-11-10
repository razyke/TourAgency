package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthService {



    public static String getSha256Hash(String source) {
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
}
