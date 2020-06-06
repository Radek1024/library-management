import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import dao.BookDao;
import dao.LibrarianDao;
import pojo.Admin;
import pojo.Book;
import pojo.Librarian;

import static dbUtils.Connect.getConnection;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection = getConnection();
        String result = connection != null ? "connected" : "not connected";
        System.out.println(result);
    }
}
