package servlets;

import model.Discount;
import model.Order;
import model.PartitionList;
import model.User;
import services.AuthService;
import services.DiscountService;
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

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageOfOrders = 1; //Parameter to method getAllOrdersByPages
        if (request.getParameter("action") != null) {
            AuthService authService = StaticContextProvider.getAuthService();
            if (request.getParameter("action").equals("detail")) {
                OrderService orderService = StaticContextProvider.getOrderService();
                Order order = orderService.getOrder(Integer.parseInt(request.getParameter("idOrder")));
                request.setAttribute("order", order);
                RequestDispatcher view = request.getRequestDispatcher(Utils.DETAIL_PAGE);
                view.forward(request, response);
            } else if (request.getParameter("action").equals("users")) {
                int pageOfUsers = 1;
                if (request.getParameter("page") != null) {
                    pageOfUsers = Integer.valueOf(request.getParameter("page"));
                }
                PartitionList<User> allUsers = authService.getAllUsers(pageOfUsers);
                request.setAttribute("users", allUsers);
                RequestDispatcher view = request.getRequestDispatcher(Utils.USERS_PAGE);
                view.forward(request, response);
            } else if (request.getParameter("action").equals("delete") || request.getParameter("action").equals("changeRole")) {

                int id = Integer.parseInt(request.getParameter("userId"));

                if (request.getParameter("action").equals("delete")) {
                    authService.deleteUser(id);
                } else if (request.getParameter("action").equals("changeRole")) {
                    authService.changeUserRole(id);
                }

                Collection<User> allUsers = authService.getAllUsers();
                request.setAttribute("users", allUsers);
                RequestDispatcher view = request.getRequestDispatcher(Utils.USERS_PAGE);
                view.forward(request, response);

            } else if (request.getParameter("action").equals("discounts")) {
                DiscountService discountService = StaticContextProvider.getDiscountService();
                Collection<Discount> allDiscounts = discountService.getAllDiscounts();
                for (Discount d : allDiscounts) {
                    d.setAuthorLogin(authService.getUser(d.getAuthorId()).getLoginName());
                }
                request.setAttribute("discounts", allDiscounts);
                RequestDispatcher view = request.getRequestDispatcher(Utils.DISCOUNT_PAGE);
                view.forward(request, response);
            }

        } else {
            //----------
            if (request.getParameter("page") != null) {
                pageOfOrders = Integer.valueOf(request.getParameter("page"));
            }
            OrderService orderService = StaticContextProvider.getOrderService();
            PartitionList<Order> allOrders = orderService.getAllOrdersByPages(pageOfOrders);
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
            if (request.getParameter("manage").equals(
                    ((ResourceBundle)request.getSession().getAttribute("bundle")).getString("global.approve"))) {
                orderService.acceptOrder(orderId);
                response.sendRedirect(Utils.ADMIN_SERVLET);
            } else if (request.getParameter("manage").equals(
                    ((ResourceBundle)request.getSession().getAttribute("bundle")).getString("global.disapprove"))){
                orderService.deleteOrder(orderId);
                response.sendRedirect(Utils.ADMIN_SERVLET);
            }
        } else if (request.getParameter("change") != null) {
            if (request.getParameter("change").equals(
                    ((ResourceBundle)request.getSession().getAttribute("bundle")).getString("global.change"))) {

                DiscountService discountService = StaticContextProvider.getDiscountService();

                String[] discountIds = request.getParameterValues("discountId");
                String[] values = request.getParameterValues("value");

                for (int i = 0; i < 2; i++) {
                    Discount discount = discountService.getDiscount(Integer.parseInt(discountIds[i]));
                    int newValue = Integer.parseInt(values[i]);
                    if (discount.getValue() != newValue) {
                        discountService.changeValue(discount.getId(),
                                newValue,
                                Integer.parseInt(
                                        String.valueOf(request.getSession().getAttribute("idUser"))));
                    }
                }
                response.sendRedirect(Utils.ADMIN_SERVLET);
            } else {
                response.sendRedirect(Utils.ADMIN_SERVLET);
            }

        } else {
            RequestDispatcher view = request.getRequestDispatcher(Utils.ADMIN_PAGE);
            view.forward(request, response);
        }
    }
}
