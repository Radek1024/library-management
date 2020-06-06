package servlets.librarian;

import dao.BookDao;
import pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBook", urlPatterns = {"/AddBook"})
public class AddBook extends HttpServlet {
    BookDao dao = new BookDao();
    Book book = new Book();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        dao.addBook(book);
        request.getRequestDispatcher("/LibrarianView").forward(request, response);
    }
}
