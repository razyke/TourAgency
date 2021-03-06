package dao;

import model.Order;
import model.Tour;
import model.User;

import javax.sql.DataSource;
import java.util.*;

/**
 * Mock UserDao for tests
 */
public class MockUserDaoImpl implements UserDao  {
    private final static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>();
        users.put(1, User.builder()
                .loginName("User1")
                .password("5e884898da2847151d0e56f8dc6292773603dd6aabbdd62a11ef721d1542d8")
                .firstName("Kip")
                .middleName("Lip")
                .lastName("Mop")
                .phone("3231321")
                .address("Street of feet")
                .email("KLP@epam.com")
                .language("EN")
                .build()
        );
        users.put(2, User.builder()
                .loginName("razyke")
                .password("8d969eef6ecad3c29a3a629280e686cfc3f5d5a86aff3ca122c923adc6c92")
                .firstName("Daniil")
                .middleName("Victorovich")
                .lastName("Smirnov")
                .phone("711133")
                .address("Zastavskaya 22")
                .email("ds@epam.com")
                .language("EN")
                .build());
    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @Override
    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findUser(String loginName) {
        for (User user : users.values()) {
            if (user.getLoginName().equals(loginName))
                return user;
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        users.remove(id);
    }

    @Override
    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public boolean isLoginUsed(String login) {
        for (User u : users.values()) {
            if (u.getLoginName().equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmailUsed(String email) {
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPhoneUsed(String phone) {
        for (User u : users.values()) {
            if (u.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}
