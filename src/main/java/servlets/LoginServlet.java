package servlets;

import dao.BeanFactory;
import dao.Dao;
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

    private Dao dao;

    public LoginServlet() {
        dao = BeanFactory.getDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(Utils.LOGIN_PAGE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = null;
        boolean hasError = false;
        String errorString = null;

        if (userName == null || password == null
                || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Error: username and password are required";
        } else {
            try {

                //user = dao.findUser(userName, AuthService.getSha256Hash(password));
                if (user == null) {
                    hasError = true;
                    errorString = "Error: Incorrect username or password";
                }
            } catch (Exception e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        if (hasError) {
            user = new User();
            user.setLoginName(userName);
            user.setPassword(password);
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);

            RequestDispatcher view = request.getRequestDispatcher(Utils.LOGIN_PAGE);
            view.forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("userName", user.getLoginName());
            RequestDispatcher view;
            if (user.isAdmin()) {
                session.setAttribute("role", "admin");
                view = request.getRequestDispatcher(Utils.ADMIN_PAGE);
            } else {
                session.setAttribute("role", "user");
                view = request.getRequestDispatcher(Utils.WELCOME_PAGE);
            }
            view.forward(request, response);
        }
    }

}
