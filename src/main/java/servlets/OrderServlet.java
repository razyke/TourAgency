package servlets;

import model.Order;
import model.Tour;
import model.User;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

                boolean error = false;

                OrderService orderService = StaticContextProvider.getOrderService();

                Order order = new Order();

                // bad think how make better.
                int idUser = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUser")));
                //order.setUserId(idUser);
                int tourId = Integer.parseInt(req.getParameter("tourId"));
                //order.setTourId(tourId);

                try {
                    Date flyDate = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("Date"));
                    order.setOrderDate(flyDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                    error = true;
                }
                order.setPrice(Integer.parseInt(req.getParameter("A TYT NADO PEREDATI NORMALINO")));
                order.setDays(Integer.parseInt(req.getParameter("I TYT TOJE DNI")));
                //Are we need is_activ ?
                if (!error) {
                    orderService.createOrder(order, idUser, tourId);
                } else {
                    System.out.println("Something bad happened =( ");
                }
            }
        }

        RequestDispatcher view = req.getRequestDispatcher(Utils.TOUR_PAGE);
        view.forward(req, resp);
    }
}
