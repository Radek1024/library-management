package servlets.librarian;

import dao.BookDao;
import pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditBook", urlPatterns = {"/EditBook"})
public class EditBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();
        Book book = new Book();
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        book.setId(Integer.parseInt(request.getParameter("id")));
        dao.editBook(book);
        request.getRequestDispatcher("/LibrarianView").forward(request,response);
    }
}
