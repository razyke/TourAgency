package servlets;

import model.Discount;
import services.DiscountsService;
import spring.StaticContextProvider;
import util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class DiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO: When will be created getDiscountService uncommented and use it.
        /*DiscountsService discountsService = StaticContextProvider.getDiscountService();
        Collection<Discount> allDiscounts = discountsService.getAllDiscounts();
        req.setAttribute("discounts", allDiscounts);*/
        RequestDispatcher view = req.getRequestDispatcher(Utils.DISCOUNT_PAGE);
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher(Utils.DISCOUNT_PAGE);
        view.forward(req,resp);
    }
}
