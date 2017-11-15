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
import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //By default will be open on english language.
        if (request.getSession().getAttribute("language") == null) {
            HttpSession session = request.getSession();
            session.setAttribute("language", "EN");
        }

        //Before user sing out, we will save information about what language he see.
        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("signOut")) {
                HttpSession session = request.getSession();
                String language = (String) session.getAttribute("language");
                session.invalidate();
                HttpSession newSession = request.getSession();
                newSession.setAttribute("language", language);
            }
        }

        //Get values from redirect address and send as attribute, after delete this value.
        checkUseAndDelete(request);

        boolean loyal = false;

        String language = String.valueOf(request.getSession().getAttribute("language"));
        ResourceBundle bundle;

        bundle =  ResourceBundle.getBundle("global", language.equals("EN") ?
                Locale.ROOT :
                new Locale("ru", "RU"));
        request.getSession().setAttribute("bundle", bundle);

        if (request.getSession().getAttribute("loyal") != null) {
            loyal = Boolean.valueOf(String.valueOf(request.getSession().getAttribute("loyal")));
        }
        TourService tourService = StaticContextProvider.getTourService();
        Collection<Tour> tours = tourService.getAllTours(
                language,
                loyal
        );
        request.setAttribute("tours", tours);
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }

    private void checkUseAndDelete(HttpServletRequest request) {
        String[] values = {"registration","message","errorMessage"};
        for (String s : values) {
            if (request.getSession().getAttribute(s) != null) {
                request.setAttribute(s, request.getSession().getAttribute(s));
                request.getSession().removeAttribute(s);
            }
        }
    }
}
