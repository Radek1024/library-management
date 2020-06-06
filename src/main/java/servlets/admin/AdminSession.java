package servlets.admin;

import dao.AdminDao;
import dao.LibrarianDao;
import pojo.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet(urlPatterns = {"/AdminSession"})
public class AdminSession extends HttpServlet {
    AdminDao adminDao = new AdminDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = adminDao.getAdmin();
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        boolean isAdmin = Stream.of(admin)
                .allMatch(a->a.getName().equals(name) && a.getEmail().equals(email));
        if (isAdmin){
            request.getSession().setAttribute("admin",admin);
            request.getRequestDispatcher("/AdminView").forward(request,response);
        }else {
            response.sendRedirect("loginPage.jsp");
        }


    }

}
