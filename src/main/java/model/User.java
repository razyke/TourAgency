package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String loginName;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String address;
    private String email;
    private String language;
    private Date lastOrderDate;
    private boolean admin;

}

