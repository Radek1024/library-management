package servlets.admin;

import dao.AdminDao;
import dao.LibrarianDao;
import pojo.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "view", urlPatterns = {"/AdminView"})
public class AdminView extends HttpServlet {
    LibrarianDao librarianDao = new LibrarianDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Librarian> list = librarianDao.getLibrarians();
        request.setAttribute("librarian",list);
        request.getRequestDispatcher("AdminView.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
