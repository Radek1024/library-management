package servlets.admin;

import dao.LibrarianDao;
import pojo.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditLib", urlPatterns = {"/GetLibrarianById"})
public class GetLibrarianById extends HttpServlet {
    LibrarianDao librarianDao = new LibrarianDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Librarian lib = librarianDao.getLibrarianById(id);
        request.setAttribute("librarian",lib);
        request.getRequestDispatcher("EditLibrarian.jsp").forward(request,response);
    }
}
