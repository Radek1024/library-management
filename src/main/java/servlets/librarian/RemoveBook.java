package servlets.librarian;

import dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveBook", urlPatterns = {"/RemoveBook"})
public class RemoveBook extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();
        String title = request.getParameter("title");

        dao.removeBookByTitle(title);
        request.getRequestDispatcher("/LibrarianView").forward(request,response);
    }
}
