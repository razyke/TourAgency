package services;

import model.Discount;
import model.Tour;
import org.junit.Before;
import org.junit.Test;
import spring.StaticContextProvider;

import java.util.Collection;

import static org.junit.Assert.*;

public class DiscountServiceTest {
    private DiscountService service;

    @Before
    public void setService() {
        service = StaticContextProvider.getDiscountService();
    }

    @Test
    public void changeValue() throws Exception {
        service.changeValue(1,25, 18);
        for (Discount d : service.getAllDiscounts()) {
            if (d.getId() == 1) {
                assertEquals(25, d.getValue());
            }
        }
        service.changeValue(1,10, 18);
    }

    @Test
    public void calculateDiscountAndPrice() throws Exception {
        service.loadDiscounts();
        Tour tour = Tour.builder()
                .id(1)
                .hot(true)
                .title("tour")
                .type("excoursion")
                .city("Spb")
                .description("desc")
                .language("EN")
                .costSevenDays(1000)
                .costTenDays(2000)
                .build();
        service.calculateDiscountAndPrice(tour, false);
        assertEquals(800, tour.getCostSevenDays());
    }

    @Test
    public void getAllDiscounts() throws Exception {
        Collection<Discount> allDiscounts = service.getAllDiscounts();
        assertEquals(allDiscounts.size(), 2);
        assertEquals("Loyal", ((Discount) allDiscounts.toArray()[0]).getName());
        assertEquals("Hot", ((Discount) allDiscounts.toArray()[1]).getName());
    }

    @Test
    public void getDiscount() throws Exception {
        Discount discount = service.getDiscount(1);
        assertEquals("Loyal", discount.getName());
        assertEquals(10, discount.getValue());
    }

}