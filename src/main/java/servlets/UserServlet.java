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

public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {

            OrderService orderService = StaticContextProvider.getOrderService();
            int idOrder = Integer.parseInt(req.getParameter("idOrder"));

            if (req.getParameter("action").equals("pay")) {
                //orderService.acceptOrder(idOrder); //TODO: NEED TO thing!!!!.
                req.getSession().setAttribute("message","Payed, wait until our manager call you");
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            } else if (req.getParameter("action").equals("delete")) {
                orderService.deleteOrder(idOrder);
                req.getSession().setAttribute("message","Order has been deleted");
                resp.sendRedirect(Utils.WELCOME_SERVLET);
            }
        } else {

            OrderService orderService = StaticContextProvider.getOrderService();
            int idUser = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUser")));
            Collection<Order> orders = orderService.getAllOrders(idUser);
            req.setAttribute("orders", orders);
            RequestDispatcher view = req.getRequestDispatcher(Utils.USER_ORDERS);
            view.forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher(Utils.USER_ORDERS);
        view.forward(req,resp);
    }
}
