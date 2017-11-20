package servlets;

import lombok.extern.log4j.Log4j;
import model.Order;
import model.Tour;
import services.OrderService;
import services.TourService;
import spring.StaticContextProvider;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

@Log4j
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String language = String.valueOf(session.getAttribute("language"));

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("order")) {
                TourService tourService = StaticContextProvider.getTourService();
                int tourId = Integer.parseInt(req.getParameter("tourId"));
                Boolean loyal = Boolean.valueOf(String.valueOf(req.getSession().getAttribute("loyal")));

                Tour tour = tourService.getTourWithDiscount(tourId, language, loyal);

                req.setAttribute("tour", tour);
            }
        }
        RequestDispatcher view = req.getRequestDispatcher(Utils.TOUR_PAGE);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                OrderService orderService = StaticContextProvider.getOrderService();
                Order order;
                boolean error = false;


                if (req.getParameter("days") != null) {
                    if (req.getParameter("days").equals("seven")) {
                        order = Order.builder()
                                .price(Integer.parseInt(req.getParameter("cost7")))
                                .days(7)
                                .active(true)
                                .build();
                    } else {
                        order = Order.builder()
                                .price(Integer.parseInt(req.getParameter("cost10")))
                                .days(10)
                                .active(true)
                                .build();
                    }

                } else {
                    order = null;
                    error = true;
                    log.error("Error to parse order from JSP page");
                }

                try {
                    Date flyDate = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("Date"));
                    order.setOrderDate(flyDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                    error = true;
                    log.error("Error to parse date");
                }

                int idUser = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUser")));
                int tourId = Integer.parseInt(req.getParameter("tourId"));

                ResourceBundle bundle = (ResourceBundle) req.getSession().getAttribute("bundle");
                if (!error && orderService.createOrder(order, idUser, tourId)) {
                    req.getSession().setAttribute("message",
                            bundle.getString("global.order_servlet"));
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                } else {
                    req.getSession().setAttribute("errorMessage",
                            bundle.getString("global.err.order_servlet"));
                    log.error("Order has not been make");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                }
            }


}
