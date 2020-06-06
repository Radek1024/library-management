package servlets.librarian;

import dao.BookDao;
import pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Rent", urlPatterns = {"/Rent"})
public class Rent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao dao = new BookDao();
        String title = request.getParameter("title");
        Book book = dao.getBookByTitle(title);
        if (book.getQuantity() > 0){
            request.setAttribute("book",book);
            request.getRequestDispatcher("RentAbook.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/LibrarianView").include(request,response);
        }
    }
}
