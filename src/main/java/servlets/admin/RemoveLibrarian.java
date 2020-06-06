package servlets.admin;

import dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Delete", urlPatterns = {"/RemoveLibrarian"})
public class RemoveLibrarian extends HttpServlet {
    LibrarianDao dao = new LibrarianDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.removeLibrarian(id);
        request.getRequestDispatcher("/AdminView").forward(request,response);
    }
}
