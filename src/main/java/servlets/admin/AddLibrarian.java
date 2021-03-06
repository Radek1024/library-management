package servlets.admin;

import dao.LibrarianDao;
import pojo.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddLibrarian", urlPatterns = {"/AddLibrarian"})
public class AddLibrarian extends HttpServlet {
    Librarian librarian = new Librarian();
    LibrarianDao dao = new LibrarianDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        librarian.setName(name);
        librarian.setLastName(lastName);
        librarian.setEmail(email);

        dao.addLibrarian(librarian);
        request.getRequestDispatcher("/AdminView").forward(request, response);
    }
}
