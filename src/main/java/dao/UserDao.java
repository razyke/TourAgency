package dao;

import model.User;

public class UserDao {
    public User findUser(String loginName, String password) {
        if (loginName.equals("User1") && password.equals("5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8")) {
            User user = new User();
            user.setLoginName("User1");
            user.setPassword("5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8");
            user.setAdmin(false);
            return user;
        }
        if (loginName.equals("razyke") && password.equals("8d969eef6ecad3c29a3a629280e686cfc3f5d5a86aff3ca122c923adc6c92")) {
            User user = new User();
            user.setLoginName("razyke");
            user.setPassword("8d969eef6ecad3c29a3a629280e686cfc3f5d5a86aff3ca122c923adc6c92");
            user.setAdmin(true);
            return user;
        }
            return null;
        }
    }

