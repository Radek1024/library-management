package servlets.admin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import dao.AdminDao;
import pojo.Admin;

@WebFilter("/AdminSession")
public class CheckIfMachDbFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        boolean isValid = Stream.of(name, email)
                .anyMatch(String::isEmpty);
        if (!isValid){
            chain.doFilter(req,resp);
        }else{
            resp.getWriter().print("<h1>Please fill the whole form</h1>");
            req.getRequestDispatcher("loginPage.jsp").include(req,resp);
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
