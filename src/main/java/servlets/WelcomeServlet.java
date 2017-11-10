package servlets;

import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String language = "EN";

        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("signOut")) {
                HttpSession session = request.getSession();
                language = (String) session.getAttribute("language");
                session.invalidate();
            }
        }


        HttpSession session = request.getSession();
        session.setAttribute("language", language);
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }
}
