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
            if (req.getParameter("manage").equals("Edit")) {
                System.out.println("EDIT");
            } else if (req.getParameter("manage").equals("Delete")) {
                int tourid = Integer.parseInt(req.getParameter("tourid"));
                tourService.deleteTour(tourid);
                req.getSession().setAttribute("message", "Tour has been deleted");
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            } else if (req.getParameter("manage").equals("Add")) {

                Tour tour = new Tour();
                tour.setCity(req.getParameter("city"));
                tour.setDescription(req.getParameter("description"));
                tour.setHot(Boolean.getBoolean(req.getParameter("isHot")));
                tour.setTitle(req.getParameter("title"));
                String language = String.valueOf(req.getSession().getAttribute("language"));
                tour.setLanguage(language);
                tour.setType(req.getParameter("typeId"));
                tour.setCostSevenDays(Integer.parseInt(req.getParameter("price7")));
                tour.setCostTenDays(Integer.parseInt(req.getParameter("price10")));

                if (tourService.addTour(tour, language)) {
                    req.getSession().setAttribute("message","Tour has been added");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                } else {
                    req.getSession().setAttribute("errorMessage", "Tour has not been added");
                    resp.sendRedirect(Utils.WELCOME_SERVLET);
                }

            } else if (req.getParameter("manage").equals("Cancel")) {
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            }
        } else {
            RequestDispatcher view = req.getRequestDispatcher(Utils.EDIT_TOUR_PAGE);
            view.forward(req,resp);
        }
    }
}
