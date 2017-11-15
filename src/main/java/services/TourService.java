package services;

import dao.TourDao;
import model.Tour;

import java.util.Collection;

public class TourService {
    private DiscountService discountService;
    private TourDao dao;

    private boolean validateTour(Tour tour) {
        return tour.getLanguage() != null
                && tour.getCostSevenDays() > 1000
                && tour.getCostTenDays() > 1000
                && !dao.isTitleUsed(tour.getTitle()) ;
    }

    /**
     * Get all tours from DB with selected language.
     * @param language - that we need.
     * @return collection of tours on selected language.
     */
    public Collection<Tour> getAllTours(String language, boolean isLoyal) {
        discountService.loadDiscounts();
        if ((!"RU".equals(language)) && (!"EN".equals(language))) {
            language = "EN";
        }

        Collection<Tour> tours = dao.getAllTours(language);

        for (Tour tour : tours) {
            discountService.calculateDiscountAndPrice(tour, isLoyal);
        }
        return tours;
    }

    /**
     * Add new tour in DB.
     * @param tour that we add in DB.
     */
    public boolean addTour(Tour tour, String language) {
        if (validateTour(tour)) {
            dao.createTour(tour);
            return true;
        }
        return false;
    }

    /**
     * Get tour by id with selected language and recalculated with discounts price from DB.
     * @param id - of tour in DB.
     * @param language - that we need (RU/EN).
     * @param isLoyal - if the user is loyal
     * @return tour.
     */
    public Tour getTourWithDiscount(int id, String language, boolean isLoyal) {
        discountService.loadDiscounts();
        Tour tour = dao.getTour(id, language);
        discountService.calculateDiscountAndPrice(tour, isLoyal);
        return tour;
    }

    /**
     * Get tour by id with selected language from DB.
     * @param id - of tour in DB.
     * @param language - that we need (RU/EN).
     * @return tour.
     */
    public Tour getTour(int id, String language) {
        return dao.getTour(id, language);
    }

    /**
     * Mark tour as hot.
     * @param id - of tour in DB.
     */
    public void markAsHot(int id) {
        Tour tour = getTour(id, "EN");
        tour.setHot(true);
        updateTour(tour);
    }

    public void deleteTour(int id) {
        dao.deleteTour(id);
    }

    /**
     * Update given tour
     * @param tour for updating
     */
    private boolean updateTour(Tour tour) {
        if (validateTour(tour)) {
            dao.updateTour(tour);
            return true;
        }
        return false;
    }

    /**
     * This is set via Beans.xml configuration
     * @param dao is dao
     **/
    public void setDao(TourDao dao) {
        this.dao = dao;
    }

    /**
     * This is set via Beans.xml configuration
     * @param discountService is discountService
     **/
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }
}
