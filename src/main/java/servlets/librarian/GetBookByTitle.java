package servlets.librarian;

import dao.BookDao;
import pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetBookByTitle", urlPatterns = {"/GetBookByTitle"})
public class GetBookByTitle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();
        String title = request.getParameter("title");
        Book book = dao.getBookByTitle(title);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/EditBook.jsp").forward(request,response);
    }
}
