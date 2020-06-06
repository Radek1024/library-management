package servlets.admin;

import dao.AdminDao;
import pojo.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateAdmin",
        urlPatterns = {"/updateAdmin"})
public class updateAdmin extends HttpServlet {
    Admin admin = new Admin();
    AdminDao dao = new AdminDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        admin.setName(request.getParameter("name"));
        admin.setEmail(request.getParameter("email"));
        admin.setId(Integer.parseInt(request.getParameter("id")));
        dao.editAdmin(admin);
        request.getRequestDispatcher("/AdminView").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
