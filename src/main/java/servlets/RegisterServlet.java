package servlets;

import dao.Dao;
import dao.BeanFactory;
import model.User;
import services.RegistrationService;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterServlet extends HttpServlet {

    private Dao dao;

    public RegisterServlet() {
        dao = BeanFactory.getDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.REGISTER_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] userStrings = new String[10];
        userStrings[0] = request.getParameter("firstName").trim();
        userStrings[1] = request.getParameter("middleName").trim();
        userStrings[2] = request.getParameter("lastName").trim();
        userStrings[3] = request.getParameter("email").trim();
        userStrings[4] = request.getParameter("phone").trim();
        userStrings[5] = request.getParameter("address").trim();
        userStrings[6] = request.getParameter("userName").trim();
        userStrings[7] = request.getParameter("password");
        userStrings[8] = request.getParameter("password2");
        //userStrings[9] = request.getParameter("language");

        List<String> errorStrings = new RegistrationService().ValidateAndSend(userStrings);
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
