package servlets.librarian;

import dao.BookDao;
import dao.UserDao;
import pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveUser", urlPatterns = {"/RemoveUser"})
public class RemoveUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        BookDao bookDao = new BookDao();

        String lastName = request.getParameter("lastName");
        String title= request.getParameter("title");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        userDao.removeUser(lastName);
        Book book = bookDao.getBookByTitle(title);
        bookDao.changeQuantity(book.getQuantity() + quantity,book.getId());

        request.getRequestDispatcher("/LibrarianView").forward(request,response);
    }
}
