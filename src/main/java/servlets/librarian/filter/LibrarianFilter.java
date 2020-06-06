package servlets.librarian.filter;

import dao.LibrarianDao;
import pojo.Librarian;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebFilter("/LibrarianSession")
public class LibrarianFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        boolean isValid = Stream.of(name,lastName,email)
                .anyMatch(String::isEmpty);
        if (!isValid){
            chain.doFilter(req,resp);
        }else{
            resp.getWriter().print("<h1>Please fill the whole form.</h1>");
            req.getRequestDispatcher("loginPage.jsp").include(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
