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

    public Tour() {
    }

    public Tour(int id, boolean hot, String title, String type, String city,
                String description, String language, int costSevenDays, int costTenDays) {
        this.id = id;
        this.hot = hot;
        this.title = title;
        this.type = type;
        this.city = city;
        this.description = description;
        this.language = language;
        this.costSevenDays = costSevenDays;
        this.costTenDays = costTenDays;
    }

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
