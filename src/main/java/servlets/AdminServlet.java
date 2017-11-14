package servlets;

import model.Order;
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
            if (request.getParameter("action").equals("detail")) {
                OrderService orderService = StaticContextProvider.getOrderService();
                Order order = orderService.getOrder(Integer.parseInt(request.getParameter("idOrder")));
                request.setAttribute("order", order);
                System.out.println(order);
                RequestDispatcher view = request.getRequestDispatcher(Utils.DETAIL_PAGE);
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


        RequestDispatcher view = request.getRequestDispatcher(Utils.ADMIN_PAGE);
        view.forward(request, response);
    }
}
