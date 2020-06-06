package dao;

import pojo.Book;
import pojo.User;
import static dbUtils.Connect.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

    public int addUser(User user){
        int output = 0;
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO users(name, lastName, address, booksRented, book, beginning, end) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getAddress());
            ps.setInt(4,user.getBooksRented());
            ps.setObject(5,user.getBook());
            ps.setDate(6, Date.valueOf(user.getBeginning()));
            ps.setDate(7, Date.valueOf(user.getEnd()));
            output = ps.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return output;
    }

    public List<User> getUsers(){
        List<User> list = new ArrayList<>(100);
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM users";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAddress(rs.getString("address"));
                user.setBooksRented(rs.getInt("booksRented"));
                user.setBook(rs.getString("book"));
                user.setBeginning( rs.getDate("beginning").toLocalDate())/*rs.getDate("beginning").toInstant().atZone(ZoneId.systemDefault()).toLocalDate())*/;
                user.setEnd(rs.getDate("end").toLocalDate());
                list.add(user);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return list.stream()
                .sorted(Comparator.comparing(User::getEnd))
                .collect(Collectors.toList());
    }
    public void removeUser(String lastName){
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM users WHERE lastName='"+lastName+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
