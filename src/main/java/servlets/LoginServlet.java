package servlets;

import model.User;
import services.AuthService;
import spring.StaticContextProvider;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;


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

        AuthService authService = StaticContextProvider.getAuthService();

        User user = new User(request.getParameter("userName"), request.getParameter("password"));
        User authUser = authService.authUser(user);
        HttpSession session = request.getSession();
        RequestDispatcher view;

        if (authUser == null) {
            String error = ((ResourceBundle)session.getAttribute("bundle")).getString("global.err.error");
            //TODO: LOG_IT
            request.setAttribute("errorString", error);
            view = request.getRequestDispatcher(Utils.LOGIN_PAGE);
            view.forward(request, response);
        } else {
            session.setAttribute("userName", authUser.getLoginName());
            if (authUser.isAdmin()) {
                session.setAttribute("idUser", authUser.getId());
                session.setAttribute("role", "admin");
                response.sendRedirect(Utils.ADMIN_SERVLET);
            } else {
                if (authService.isLoyalCustomer(authUser)) {
                    session.setAttribute("loyal",true);
                } else {
                    session.setAttribute("loyal", false);
                }
                session.setAttribute("idUser", authUser.getId());
                session.setAttribute("role", "user");
                response.sendRedirect(Utils.WELCOME_SERVLET);
            }
        }
    }
}
