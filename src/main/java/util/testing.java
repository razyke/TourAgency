package util;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class testing {
    public static void main(String[] args) {
        //TODO: Гигантский костыль для передачи из фиговой кодировки в нужную.
        ResourceBundle bundle = ResourceBundle.getBundle("global", new Locale("ru", "RU"));
        String string = bundle.getString("global.submit");
        try {
            String s = new String(string.getBytes("CP1252"), "CP1251");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
