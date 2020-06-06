package dao;
import pojo.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static dbUtils.Connect.getConnection;

public class BookDao {
    public void addBook(Book book){
        try{
            Connection connection = getConnection();
            String query = "INSERT INTO books (title, author, quantity) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getQuantity());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Book> queryBooks(){
        List<Book> list = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String query = "SELECT * FROM books";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                book.setId(rs.getInt("id"));
                list.add(book);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void removeBookByTitle(String title){
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM books WHERE title='"+title+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Book getBookByTitle(String title){
        Book book = new Book();
        try{
            Connection connection = getConnection();
            String query = "SELECT * FROM books WHERE title='"+title+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                book.setId(rs.getInt("id"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return book;
    }

    public void editBook(Book book){
        try {
            Connection connection = getConnection();
            String query = "UPDATE books SET title=?, author=?, quantity=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getQuantity());
            ps.setInt(4,book.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void changeQuantity(int quantity, int id){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "UPDATE books SET quantity='"+ quantity + "' WHERE id='"+id+"'";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
