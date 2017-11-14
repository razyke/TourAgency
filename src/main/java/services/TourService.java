package services;

import dao.TourDao;
import model.Tour;
import spring.StaticContextProvider;

import java.util.Collection;

public class TourService {
    private DiscountService discountService = StaticContextProvider.getDiscountsService();
    private TourDao dao;

    /**
     * Get all tours from DB with selected language.
     * @param language - that we need.
     * @return collection of tours on selected language.
     */
    public Collection<Tour> getAllTours(String language, boolean isLoyal) {
        if ((!"RU".equals(language)) && (!"EN".equals(language))) {
            language = "EN";
        }
        Collection<Tour> tours = dao.getAllTours(language);
        for (Tour tour : tours) {
            tour.setCostSevenDays(
                    discountService.calculatePrice(
                            tour.getCostSevenDays(),
                            tour.isHot(),
                            isLoyal
                    )
            );
            tour.setCostTenDays(
                    discountService.calculatePrice(
                            tour.getCostTenDays(),
                            tour.isHot(),
                            isLoyal
                    )
            );
        }
        return tours;
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
     * Mark tour as hot.
     * @param id - of tour in DB.
     */
    public void markAsHot(int id) {
        Tour tour = getTour(id, "EN");
        tour.setHot(true);
        updateTour(tour);
    }

    /**
     * Update given tour
     * @param tour for updating
     */
    public void updateTour(Tour tour) {
        dao.updateTour(tour);
    }

    /**
     * This is set via Beans.xml configuration
     * @param dao is dao
     **/
    public void setDao(TourDao dao) {
        this.dao = dao;
    }
}
