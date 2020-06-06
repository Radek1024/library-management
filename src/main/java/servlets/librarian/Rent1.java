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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "Rent1",urlPatterns = {"/Rent1"})
public class Rent1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        int booksRented = Integer.parseInt(request.getParameter("booksRented"));
        String title = request.getParameter("book");
        LocalDate beginning = LocalDate.now().plusDays(1);
        LocalDate end = beginning.plusDays(14);

        UserDao dao = new UserDao();
        User user = new User();
        BookDao bookDao = new BookDao();

        user.setName(name);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setBooksRented(booksRented);
        user.setBook(title);
        user.setBeginning(beginning);
        user.setEnd(end);

        Book book = bookDao.getBookByTitle(title);
        bookDao.changeQuantity(book.getQuantity()-booksRented,book.getId());
        dao.addUser(user);
        request.getRequestDispatcher("/LibrarianView").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
