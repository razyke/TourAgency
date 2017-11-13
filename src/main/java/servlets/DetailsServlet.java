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

public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("details")) {
                //TODO: Uncomment when OrderService fix.
                /*OrderService orderService = StaticContextProvider.getOrderService();
                Order order = orderService.getOrder(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("order", order);*/
            }
        }
        RequestDispatcher view = req.getRequestDispatcher(Utils.DETAIL_PAGE);
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher(Utils.DETAIL_PAGE);
        view.forward(req,resp);
    }
}
