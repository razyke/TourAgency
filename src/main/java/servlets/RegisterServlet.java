package servlets;

import dao.Dao;
import dao.DaoFactory;
import model.User;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private Dao dao;

    public RegisterServlet() {
        dao = DaoFactory.getDao();
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

        User user = new User();
        user.setLoginName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        dao.createUser(user);


    }
}
