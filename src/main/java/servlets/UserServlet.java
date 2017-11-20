package servlets;

import model.Order;
import model.PartitionList;
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

        if (req.getParameter("action") != null) {

            OrderService orderService = StaticContextProvider.getOrderService();
            int idOrder = Integer.parseInt(req.getParameter("idOrder"));
            ResourceBundle bundle = (ResourceBundle) req.getSession().getAttribute("bundle");

            if (req.getParameter("action").equals("pay")) {
                //Is not prepared.
                req.getSession().setAttribute("message",
                        bundle.getString("global.payed"));
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            } else if (req.getParameter("action").equals("delete")) {
                orderService.deleteOrder(idOrder);
                req.getSession().setAttribute("message",
                        bundle.getString("global.deleted"));
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            }
        } else {

            int pageOfOrders = 1;

            if (req.getParameter("page") != null) {
                pageOfOrders = Integer.valueOf(req.getParameter("page"));
            }
            OrderService orderService = StaticContextProvider.getOrderService();

            int idUser = 0;

            if (req.getSession().getAttribute("idUser") != null) {
                idUser = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUser")));
            }
            PartitionList<Order> orders = orderService.getAllOrdersByPages(idUser, pageOfOrders);

            req.setAttribute("orders", orders);
            RequestDispatcher view = req.getRequestDispatcher(Utils.USER_ORDERS_PAGE);
            view.forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher(Utils.USER_ORDERS_PAGE);
        view.forward(req,resp);
    }
}
