package model;

public class Tour {
    private int id;
    private boolean hot;
    private String title;
    private String type;
    private String city;
    private String description;
    private String language;
    private int costSevenDays;
    private int costTenDays;

    public int getCostSevenDays() {
        return costSevenDays;
    }

    public void setCostSevenDays(int costSevenDays) {
        this.costSevenDays = costSevenDays;
    }

    public int getCostTenDays() {
        return costTenDays;
    }

    public void setCostTenDays(int costTenDays) {
        this.costTenDays = costTenDays;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
