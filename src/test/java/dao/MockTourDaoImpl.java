package dao;

import model.Tour;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockTourDaoImpl implements TourDao {
    private final static Map<Integer, Tour> tours = new HashMap<Integer, Tour>();

    {
        tours.put(1, new Tour(1, false, "tour1", "excursion", "spb",
                "description1", "EN", 1000, 2000));
        tours.put(2, new Tour(2, true, "tour2", "rest", "msk",
                "description2", "RU", 2000, 4000));
        tours.put(3, new Tour(3, false, "tour3", "excursion", "msk",
                "description3", "EN", 8000, 10000));
    }


    @Override
    public Tour getTour(int id, String language) {
        Tour tour = tours.get(id);
        if (tour.getLanguage().equals(language)) {
            return tour;
        }
        return null;
    }

    @Override
    public Collection<Tour> getAllTours(String language) {
        Collection<Tour> out = new ArrayList<Tour>();
        for (Tour tour : tours.values()) {
            if (tour.getLanguage().equals(language)) {
                out.add(tour);
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
