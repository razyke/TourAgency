package model;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
public class Discount {

    private int id;
    private String name;
    private int value;
    private int authorId;
    private Date lastUpdate;
    private String authorLogin;

}
