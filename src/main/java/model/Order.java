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
public class Order {

    private int id;
    private User user;
    private Tour tour;
    private int price;
    private int days;
    private boolean active = true;
    private Date orderDate;

}

