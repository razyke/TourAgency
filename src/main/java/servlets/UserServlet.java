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
import java.util.ResourceBundle;

public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderService orderService = StaticContextProvider.getOrderService();
        int idUser = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUser")));
        Collection<Order> orders = orderService.getAllOrders(idUser);
        //TODO put only currents user's orders in this request
        req.setAttribute("orders", orders);
        RequestDispatcher view = req.getRequestDispatcher(Utils.USER_ORDERS);
        view.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("manage") != null) {
            OrderService orderService = StaticContextProvider.getOrderService();
            int orderId = Integer.parseInt(req.getParameter("orderId"));
            if (req.getParameter("manage").equals(
                    ((ResourceBundle) req.getSession().getAttribute("bundle")).getString("global.approve"))) {
                orderService.acceptOrder(orderId);
                resp.sendRedirect(Utils.USER_ORDERS);
            } else if (req.getParameter("manage").equals(
                    ((ResourceBundle) req.getSession().getAttribute("bundle")).getString("global.disapprove"))) {
                orderService.deleteOrder(orderId);
                resp.sendRedirect(Utils.USER_ORDERS);
            }
        }
        super.doPost(req, resp);
    }
}
