package model;

import java.util.Date;

public class Order {

    private int id;
    private User user;
    private Tour tour;
    private int price;
    private int days;
    private boolean active = true;
    private Date orderDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order() {
    }

    //TODO: Delete unnecessary constructor
    public Order(int price, int days) {
        this.price = price;
        this.days = days;
    }

    public Order(int price, int days, Date orderDate) {
        this.price = price;
        this.days = days;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ",\nuser=" + user +
                ",\ntour=" + tour +
                ",\nprice=" + price +
                ",\ndays=" + days +
                ",\nactive=" + active +
                '}';
    }
}
