package services;

import dao.Dao;
import model.Tour;

import java.util.Collection;

public class TourService {
    private Dao dao;

    public Collection<Tour> getAllTours(String language) {
        if (!"RU".equals(language) && "EN".equals(language)) {
            language = "EN";
        }
        return dao.getAllTours(language);
    }

    public void addTour(Tour tour) {
        if (dao.isExist("tour_details", "title", tour.getTitle())) {
            dao.createTour(tour);
        }
    }

    /**
     * This is set via Beans.xml configuration
     * @param dao
     **/
    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
