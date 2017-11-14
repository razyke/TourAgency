package servlets;

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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServlet extends HttpServlet {

    private int tourId = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("order")) {
                TourService tourService = StaticContextProvider.getTourService();
                tourId = Integer.parseInt(req.getParameter("tourId"));
                Tour tour = tourService.getTour(
                        tourId,
                        String.valueOf(req.getSession().getAttribute("language"))
                );
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
                        order = new Order(1313, 7);
                    } else {
                        order = new Order(2424,10);
                    }

                } else {
                    order = null;
                    error = true;
                }

                try {
                    Date flyDate = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("Date"));
                    order.setOrderDate(flyDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                    error = true;
                }

                // bad think how make better.
                int idUser = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUser")));

                if (orderService.createOrder(order, idUser, tourId) && !error) {
                    req.setAttribute("message", "Ordered, please wait, our manager contact with you.");
                    RequestDispatcher view = req.getRequestDispatcher(Utils.WELCOME_PAGE);
                    view.forward(req,resp);
                } else {
                    req.setAttribute("errorMessage", "Tour has not been ordered");
                    RequestDispatcher view = req.getRequestDispatcher(Utils.WELCOME_PAGE);
                    view.forward(req,resp);
                }
            }


}
