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
import java.io.IOException;
import java.util.List;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.REGISTER_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User(
                request.getParameter("userName").trim(),
                request.getParameter("password"),
                request.getParameter("firstName").trim(),
                request.getParameter("lastName").trim(),
                request.getParameter("middleName").trim(),
                request.getParameter("phone").trim(),
                request.getParameter("address").trim(),
                request.getParameter("email").trim()
                );
        //language add.

        AuthService authService = BeanFactory.getAuthService();

        List<String> errorStrings = authService.ValidateAndSend(
                user, request.getParameter("password2"));

        if (errorStrings == null) {
            RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
            request.setAttribute("registration", "Registration success!");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher(Utils.REGISTER_PAGE);
            request.setAttribute("registration", errorStrings);
            view.forward(request, response);
        }
    }
}
