package servlets;

import model.Order;
import model.User;
import services.AuthService;
import services.OrderService;
import spring.StaticContextProvider;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("action") != null) {
            AuthService authService = StaticContextProvider.getAuthService();
            if (request.getParameter("action").equals("detail")) {
                OrderService orderService = StaticContextProvider.getOrderService();
                Order order = orderService.getOrder(Integer.parseInt(request.getParameter("idOrder")));
                request.setAttribute("order", order);
                RequestDispatcher view = request.getRequestDispatcher(Utils.DETAIL_PAGE);
                view.forward(request, response);
            } else if (request.getParameter("action").equals("users")) {
                Collection<User> allUsers = authService.getAllUsers();
                request.setAttribute("users", allUsers);
                RequestDispatcher view = request.getRequestDispatcher(Utils.USERS_PAGE);
                view.forward(request, response);
            } else if (request.getParameter("action").equals("delete")) {
                authService.deleteUser(Integer.parseInt(request.getParameter("userId")));
                Collection<User> allUsers = authService.getAllUsers();
                request.setAttribute("users", allUsers);
                RequestDispatcher view = request.getRequestDispatcher(Utils.USERS_PAGE);
                view.forward(request, response);
            }

        } else {
            OrderService orderService = StaticContextProvider.getOrderService();
            Collection<Order> allOrders = orderService.getAllOrders();

            request.setAttribute("orders", allOrders);

            RequestDispatcher view = request.getRequestDispatcher(Utils.ADMIN_PAGE);
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("manage") != null) {
            OrderService orderService = StaticContextProvider.getOrderService();
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            if (request.getParameter("manage").equals("Approve")) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                AuthService authService = StaticContextProvider.getAuthService();
                authService.updateUserLastOrder(userId);
                orderService.deleteOrder(orderId);
                response.sendRedirect(Utils.ADMIN_SERVLET);
            } else if (request.getParameter("manage").equals("Disapprove")) {
                orderService.deleteOrder(orderId);
                response.sendRedirect(Utils.ADMIN_SERVLET);
            }
        } else {
            RequestDispatcher view = request.getRequestDispatcher(Utils.ADMIN_PAGE);
            view.forward(request, response);
        }
    }
}
