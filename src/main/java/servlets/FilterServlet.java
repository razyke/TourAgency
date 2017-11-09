package servlets;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterServlet implements Filter{

    private FilterConfig config;

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        ServletContext context = config.getServletContext();

        context.log("doFilter called in: " + config.getFilterName() + " on " + (new java.util.Date()));

        context.log("session ID: " + session.getId());

        String logged = (String) session.getAttribute("logged-in");
        if (logged == null)
            session.setAttribute("logged-in", "no");

        //log a message about the log-in status
        context.log("log-in status: "
                + (String) session.getAttribute("logged-in"));
        context.log("");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Instance created of " + getClass().getName());
        this.config = filterConfig;

    }

    public void destroy() {

    }
}
