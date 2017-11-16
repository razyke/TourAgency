package services;

import model.Tour;
import org.junit.Test;
import spring.StaticContextProvider;

import java.util.Collection;

import static org.junit.Assert.*;

public class TourServiceTest {
    private TourService service = StaticContextProvider.getTourService();

    @Test
    public void getAllTours() throws Exception {
        Collection<Tour> en = service.getAllTours("EN", false);
        assertEquals(2, en.size());
        Tour[] tours = new Tour[2];
        en.toArray(tours);
        assertEquals(1, tours[0].getId());
        assertEquals(3, tours[1].getId());
    }

    @Test
    public void addTour() throws Exception {
        Tour tour = new Tour(
                5, false, "Tour1", "type", "city", "desc", "en",
                1500, 2000
        );
        assertTrue(service.addTour(tour));

        assertFalse(service.addTour(tour));
    }

    @Test
    public void getTourWithDiscount() throws Exception {
        assertEquals(1500, service.getTourWithDiscount(1, "EN",false).getCostSevenDays());
        assertEquals(1350, service.getTourWithDiscount(1, "EN",true).getCostSevenDays());
        assertEquals(1600, service.getTourWithDiscount(2, "RU",false).getCostSevenDays());
        assertEquals(1600, service.getTourWithDiscount(2, "RU",true).getCostSevenDays());
        assertEquals(7200, service.getTourWithDiscount(3, "EN",true).getCostSevenDays());

    }

    @Test
    public void getTour() throws Exception {
        assertNull(service.getTour(11, "EN"));
        assertNotNull(service.getTour(1, "EN"));
    }

    @Test
    public void deleteTour() throws Exception {
        service.deleteTour(4);
        assertNull(service.getTour(4, "RU"));
    }
}