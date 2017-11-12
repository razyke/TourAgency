package services;

import dao.TourDao;
import model.Tour;

import java.util.Collection;

public class TourService {
    private TourDao dao;

    public Collection<Tour> getAllTours(String language) {
        if ((!"RU".equals(language)) && (!"EN".equals(language))) {
            language = "EN";
        }
        return dao.getAllTours(language);
    }

    public void addTour(Tour tour) {
        if (!dao.isTitleUsed(tour.getTitle())) {
            dao.createTour(tour);
        }
    }

    /**
     * This is set via Beans.xml configuration
     * @param dao is dao
     **/
    public void setDao(TourDao dao) {
        this.dao = dao;
    }
}
