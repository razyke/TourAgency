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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String language;

        //By default will be open on english language.
        if (request.getSession().getAttribute("language") == null) {
            language = "EN";
        } else {
            language = String.valueOf(request.getSession().getAttribute("language"));
        }

        //Before user sing out, we will save information about what language he see.
        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("signOut")) {
                HttpSession session = request.getSession();
                language = (String) session.getAttribute("language");
                session.invalidate();
            }
        }


        HttpSession session = request.getSession();
        session.setAttribute("language", language);
        TourService tourService = StaticContextProvider.getTourService();
        Collection<Tour> tours = tourService.getAllTours(language);
        request.setAttribute("tours", tours);
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }
}
