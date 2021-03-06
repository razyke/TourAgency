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
        String language = String.valueOf(request.getSession().getAttribute("language"));

        User user = User.builder()
                .loginName(request.getParameter("userName").trim())
                .password(request.getParameter("password"))
                .firstName(request.getParameter("firstName").trim())
                .lastName(request.getParameter("lastName").trim())
                .middleName(request.getParameter("middleName").trim())
                .phone(request.getParameter("phone").trim())
                .address(request.getParameter("address").trim())
                .email(request.getParameter("email").trim())
                .language(language)
                .build();


        AuthService authService = StaticContextProvider.getAuthService();

        List<String> errorStrings = authService.ValidateAndSend(
                user, request.getParameter("password2"));

        if (errorStrings == null) {
            RequestDispatcher view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
            request.getSession().setAttribute("registration","Registration success!");
            response.sendRedirect(Utils.WELCOME_SERVLET);

        } else {
            RequestDispatcher view = request.getRequestDispatcher(Utils.REGISTER_PAGE);
            request.setAttribute("registration", errorStrings);
            view.forward(request, response);
        }
    }
}
