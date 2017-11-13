package servlets;

import model.Order;
import model.Tour;
import services.AuthService;
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

public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("order")) {
                TourService tourService = StaticContextProvider.getTourService();
                Tour tour = tourService.getTour(Integer.parseInt(req.getParameter("tourId")),
                        String.valueOf(req.getSession().getAttribute("language")));
                req.setAttribute("tour", tour);
            }
        }

        RequestDispatcher view = req.getRequestDispatcher(Utils.TOUR_PAGE);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("order")) {
                OrderService orderService = StaticContextProvider.getOrderService();
                AuthService authService = StaticContextProvider.getAuthService();
                String userName = String.valueOf(req.getSession().getAttribute("userName"));
                //authService.authUser(userName);

                req.getParameter("tourId");

                Order order = new Order();
               /* order.setUser();
                order.setTour();*/

                orderService.createOrder(order);
                //order.setDays();
            }
        }

        RequestDispatcher view = req.getRequestDispatcher(Utils.TOUR_PAGE);
        view.forward(req, resp);
    }
}
