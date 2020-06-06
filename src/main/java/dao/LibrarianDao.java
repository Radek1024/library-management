package dao;

import pojo.Librarian;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static dbUtils.Connect.getConnection;

public class LibrarianDao {

    public void addLibrarian(Librarian librarian){
        try{
            Connection connection = getConnection();
            String query = "INSERT INTO librarian (name, lastName, email) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,librarian.getName());
            ps.setString(2,librarian.getLastName());
            ps.setString(3,librarian.getEmail());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Librarian> getLibrarians(){
        List<Librarian> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM librarian";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Librarian librarian = new Librarian();
                librarian.setName(rs.getString("name"));
                librarian.setLastName(rs.getString("lastName"));
                librarian.setEmail(rs.getString("email"));
                librarian.setId(rs.getInt("id"));
                list.add(librarian);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Librarian getLibrarianById(int id){
        Librarian librarian = new Librarian();
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query="SELECT * FROM librarian WHERE id="+id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                librarian.setName(rs.getString("name"));
                librarian.setLastName(rs.getString("lastName"));
                librarian.setEmail(rs.getString("email"));
                librarian.setId(rs.getInt("id"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return librarian;
    }

    public void editLibrarian(Librarian librarian){
        try {
            Connection connection = getConnection();
            String query = "UPDATE librarian SET name=?, lastName=?, email=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,librarian.getName());
            ps.setString(2,librarian.getLastName());
            ps.setString(3,librarian.getEmail());
            ps.setInt(4,librarian.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeLibrarian(int id){
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM librarian WHERE id="+id;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
