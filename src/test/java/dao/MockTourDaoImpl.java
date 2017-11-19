package dao;

import model.Tour;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockTourDaoImpl implements TourDao {
    private final static Map<Integer, Tour> tours;

    static {
        tours = new HashMap<Integer, Tour>();
        tours.put(1, Tour.builder()
                .id(1)
                .hot(false)
                .title("tour1")
                .type("excursion")
                .city("spb")
                .description("description2")
                .language("EN")
                .costSevenDays(1500)
                .costTenDays(2000)
                .build()
        );
        tours.put(2, Tour.builder()
                .id(2)
                .hot(true)
                .title("tour2")
                .type("rest")
                .city("msk")
                .description("description2")
                .language("RU")
                .costSevenDays(2000)
                .costTenDays(4000)
                .build()
        );
        tours.put(3, Tour.builder()
                .id(3)
                .hot(false)
                .title("tour3")
                .type("excursion")
                .city("msk")
                .description("description3")
                .language("EN")
                .costSevenDays(8000)
                .costTenDays(10000)
                .build()
        );
        tours.put(4, Tour.builder()
                .id(4)
                .hot(false)
                .title("tour4")
                .type("type")
                .city("city")
                .description("description4")
                .language("RU")
                .costSevenDays(1500)
                .costTenDays(2000)
                .build()
        );
    }


    @Override
    public Tour getTour(int id, String language) {
        Tour tour = tours.get(id);
        if (tour != null && tour.getLanguage().equals(language)) {
            return Tour.builder()
                    .id(tour.getId())
                    .hot(tour.isHot())
                    .title(tour.getTitle())
                    .city(tour.getCity())
                    .description(tour.getDescription())
                    .language(tour.getLanguage())
                    .costSevenDays(tour.getCostSevenDays())
                    .costTenDays(tour.getCostTenDays())
                    .build();
        }
        return null;
    }

    @Override
    public Collection<Tour> getAllTours(String language) {
        Collection<Tour> out = new ArrayList<Tour>();
        for (Tour tour : tours.values()) {
            if (tour.getLanguage().equals(language)) {
                Tour tour1 = Tour.builder()
                        .id(tour.getId())
                        .hot(tour.isHot())
                        .title(tour.getTitle())
                        .city(tour.getCity())
                        .description(tour.getDescription())
                        .language(tour.getLanguage())
                        .costSevenDays(tour.getCostSevenDays())
                        .costTenDays(tour.getCostTenDays())
                        .build();

                out.add(tour1);
            }
        }
        return out;
    }

    @Override
    public void createTour(Tour tour) {
        tours.put(tour.getId(), tour);
    }

    @Override
    public void deleteTour(int id) {
        tours.remove(id);
    }

    @Override
    public void updateTour(Tour tour) {
        tours.put(tour.getId(), tour);
    }

    @Override
    public boolean isTitleUsed(String title) {
        for (Tour tour : tours.values()) {
            if (tour.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
