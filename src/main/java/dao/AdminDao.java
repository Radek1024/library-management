package dao;

import pojo.Admin;
import java.sql.*;
import static dbUtils.Connect.getConnection;

public class AdminDao {

    public Admin getAdmin() {
        Admin admin = new Admin();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM admin");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                admin.setName(resultSet.getString("name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public Admin getAdminById(int id){
        Admin admin = new Admin();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM admin WHERE id='"+id+"'");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                admin.setName(resultSet.getString("name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    public void addAdmin(Admin admin){
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "INSERT INTO admin (email, id, name) value ('"+admin.getEmail()+"','"+
                    admin.getId()+"','"+
                    admin.getName()+"')";
            st.execute(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void editAdmin(Admin admin){
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            String query = "UPDATE admin SET name='" + admin.getName()+"', email='"+admin.getEmail()+"' WHERE id='"+admin.getId()+"'";
            st.execute(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
