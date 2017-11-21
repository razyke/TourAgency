package servlets;

import model.Tour;
import services.TourService;
import spring.StaticContextProvider;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class EditTourServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("edit")) {
                TourService tourService = StaticContextProvider.getTourService();
                Tour tour = tourService.getTour(
                        Integer.parseInt(String.valueOf(req.getParameter("tourId"))),
                        String.valueOf(req.getSession().getAttribute("language")));
                req.setAttribute("tour",tour);
                RequestDispatcher view = req.getRequestDispatcher(Utils.EDIT_TOUR_PAGE);
                view.forward(req,resp);
            } else if (req.getParameter("action").equals("addTour")) {
                RequestDispatcher view = req.getRequestDispatcher(Utils.EDIT_TOUR_PAGE);
                view.forward(req,resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("manage") != null) {
            TourService tourService = StaticContextProvider.getTourService();
            String language = String.valueOf(req.getSession().getAttribute("language"));
            String message = "message";
            String errorMessage = "errorMessage";

            if (req.getParameter("manage").equals(
                    ((ResourceBundle)req.getSession().getAttribute("bundle")).getString("global.edit"))) {
                boolean hot = false;
                if (req.getParameter("isHot") != null) {
                    hot = req.getParameter("isHot").equals("true");
                }
                Tour tour = Tour.builder()
                        .hot(hot)
                        .title(req.getParameter("title"))
                        .type(req.getParameter("typeId"))
                        .city(req.getParameter("city"))
                        .description(req.getParameter("description"))
                        .language(language)
                        .costSevenDays(Integer.parseInt(req.getParameter("price7")))
                        .costTenDays(Integer.parseInt(req.getParameter("price10")))
                        .build();

                int tourid = Integer.parseInt(req.getParameter("tourid"));
                tour.setId(tourid);

                if (tourService.updateTour(tour)) {
                    req.getSession().setAttribute(message, "Tour has been updated");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                } else {
                    req.getSession().setAttribute(errorMessage, "Fail to update tour");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                }

            } else if (req.getParameter("manage").equals(
                    ((ResourceBundle)req.getSession().getAttribute("bundle")).getString("global.delete"))) {
                int tourid = Integer.parseInt(req.getParameter("tourid"));
                tourService.deleteTour(tourid);
                req.getSession().setAttribute(message, "Tour has been deleted");
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            } else if (req.getParameter("manage").equals(
                    ((ResourceBundle)req.getSession().getAttribute("bundle")).getString("global.add"))) {
                boolean hot = false;
                if (req.getParameter("isHot") != null) {
                    hot = req.getParameter("isHot").equals("true");
                }
                Tour tour = Tour.builder()
                        .hot(hot)
                        .title(req.getParameter("title"))
                        .type(req.getParameter("typeId"))
                        .city(req.getParameter("city"))
                        .description(req.getParameter("description"))
                        .language(language)
                        .costSevenDays(Integer.parseInt(req.getParameter("price7")))
                        .costTenDays(Integer.parseInt(req.getParameter("price10")))
                        .build();

                if (tourService.addTour(tour)) {
                    req.getSession().setAttribute(message,"Tour has been added");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                } else {
                    req.getSession().setAttribute(errorMessage, "Tour has not been added");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                }

            } else if (req.getParameter("manage").equals(
                    ((ResourceBundle)req.getSession().getAttribute("bundle")).getString("global.cancel"))) {
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            }
        } else {
            RequestDispatcher view = req.getRequestDispatcher(Utils.EDIT_TOUR_PAGE);
            view.forward(req,resp);
        }
    }
}
