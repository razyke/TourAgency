package servlets;

import dao.BeanFactory;
import model.User;
import services.AuthService;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.LOGIN_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AuthService authService = BeanFactory.getAuthService();

        User user = new User(request.getParameter("userName"), request.getParameter("password"));
        User authUser = authService.authUser(user);
        HttpSession session = request.getSession();
        RequestDispatcher view;

        if (authUser == null) {
            request.setAttribute("errorString", "Error!");
            view = request.getRequestDispatcher(Utils.LOGIN_PAGE);
        } else {
            session.setAttribute("userName", authUser.getLoginName());
            if (authUser.isAdmin()) {
                session.setAttribute("role", "admin");
                view = request.getRequestDispatcher(Utils.ADMIN_PAGE);
            } else {
                session.setAttribute("role", "user");
                view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
            }
        }

        view.forward(request, response);
    }
}
