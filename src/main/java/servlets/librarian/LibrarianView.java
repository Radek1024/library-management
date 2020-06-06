package servlets.librarian;

import dao.BookDao;
import dao.UserDao;
import pojo.Book;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "LibrarianView", urlPatterns = {"/LibrarianView"})
public class LibrarianView extends HttpServlet {
    BookDao dao = new BookDao();
    UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = dao.queryBooks();
        List<User> list1 = userDao.getUsers();
        request.setAttribute("books",list);
        request.setAttribute("users",list1);
        request.getRequestDispatcher("LibrarianView.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
