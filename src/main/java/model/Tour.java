package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private int discount;

}
