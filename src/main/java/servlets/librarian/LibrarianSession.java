package servlets.librarian;

import dao.LibrarianDao;
import pojo.Librarian;
import servlets.librarian.filter.LibrarianFilter;
import pojo.Librarian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "LibrarianSession", urlPatterns = {"/LibrarianSession"})
public class LibrarianSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        LibrarianDao dao = new LibrarianDao();
        List<Librarian> user = dao.getLibrarians().stream()
                .filter(e -> e.getName().equals(name))
                .filter(e -> e.getLastName().equals(lastName))
                .filter(e -> e.getEmail().equals(email))
                .collect(Collectors.toList());
        if (!user.isEmpty()) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/LibrarianView").forward(request, response);
        } else {
            response.getWriter().print("<h1>Please fill in correct data.</h1>");
            request.getRequestDispatcher("loginPage.jsp").include(request, response);
        }

    }

}