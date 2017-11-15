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
            if (req.getParameter("manage").equals("Edit")) {
                System.out.println("EDIT");
            } else if (req.getParameter("manage").equals("Delete")) {
                System.out.println("DELETE");
            } else if (req.getParameter("manage").equals("Add")) {
                System.out.println("ADD");
            } else if (req.getParameter("manage").equals("Cancel")) {
                System.out.println("CANCEL");
            }
        }


        RequestDispatcher view = req.getRequestDispatcher(Utils.EDIT_TOUR_PAGE);
        view.forward(req,resp);
    }
}
