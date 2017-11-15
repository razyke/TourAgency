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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String language = String.valueOf(session.getAttribute("language"));

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("order")) {
                TourService tourService = StaticContextProvider.getTourService();
                int tourId = Integer.parseInt(req.getParameter("tourId"));
                Tour tour;
                if (Boolean.valueOf(String.valueOf(req.getSession().getAttribute("loyal")))) {
                    tour = tourService.getTourWithDiscount(
                            tourId,
                            language,
                            true
                    );
                } else {
                    tour = tourService.getTour(
                            tourId,
                            language
                    );
                }
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
                        order = new Order(Integer.parseInt(req.getParameter("cost7")), 7);
                    } else {
                        order = new Order(Integer.parseInt(req.getParameter("cost10")),10);
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
                int tourId = Integer.parseInt(req.getParameter("tourId"));
               // int tourId = Integer.parseInt(String.valueOf(req.getSession().getAttribute("tourId")));

                if (!error && orderService.createOrder(order, idUser, tourId)) {
                    req.getSession().setAttribute("message","Ordered, please wait, our manager contact with you.");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                    //req.setAttribute("message", "Ordered, please wait, our manager contact with you.");
                    //RequestDispatcher view = req.getRequestDispatcher(Utils.WELCOME_PAGE);
                    //view.forward(req,resp);
                } else {
                    req.getSession().setAttribute("errorMessage", "Tour has not been ordered");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                    //req.setAttribute("errorMessage", "Tour has not been ordered");
                    //RequestDispatcher view = req.getRequestDispatcher(Utils.WELCOME_PAGE);
                    //view.forward(req,resp);
                }
            }


}
