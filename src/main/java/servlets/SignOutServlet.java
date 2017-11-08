package servlets;

import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO Figure out why after admin login we submit button "sing out" and received doGET method, after second try we go in doPost method.
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
        view.forward(request, response);
    }
}
