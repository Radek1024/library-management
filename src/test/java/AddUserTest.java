import dao.BookDao;
import dao.UserDao;
import pojo.Book;
import pojo.User;
import java.time.LocalDate;
import dao.BookDao;

public class AddUserTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Modern tv show");
        book.setAuthor("John Connor");
        book.setQuantity(1);
        book.setId(20);

        LocalDate now = LocalDate.now();
        User user = new User();
        user.setName("Jerry");
        user.setLastName("Springer");
        user.setAddress("Los Angeles , 101 Mull Holland Drive, CA");
        user.setBook(book.toString());
        user.setBooksRented(1);
        user.setBeginning(now);
        user.setEnd(now.plusDays(14));

        /*UserDao dao = new UserDao();
        String test = dao.addUser(user) > 0 ? "yupi!":"not yupi";
        System.out.println(test);*/

    }

}