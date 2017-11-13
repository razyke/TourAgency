package services;

import dao.TourDao;
import model.Tour;

import java.util.Collection;

public class TourService {

    private TourDao dao;

    /**
     * Get all tours from DB with selected language.
     * @param language - that we need.
     * @return collection of tours on selected language.
     */
    public Collection<Tour> getAllTours(String language) {
        if ((!"RU".equals(language)) && (!"EN".equals(language))) {
            language = "EN";
        }
        return dao.getAllTours(language);
    }

    /**
     * Add new tour in DB.
     * @param tour that we add in DB.
     */
    public void addTour(Tour tour) {
        if (!dao.isTitleUsed(tour.getTitle())) {
            dao.createTour(tour);
        }
    }

    /**
     * Get tour by id with selected language from DB.
     * @param id - of tour in DB.
     * @param language - that we need (RU/EN).
     * @return tour.
     */
    public Tour getTour(int id, String language) {
        return dao.getTour(id,language);
    }

    /**
     * This is set via Beans.xml configuration
     * @param dao is dao
     **/
    public void setDao(TourDao dao) {
        this.dao = dao;
    }
}
