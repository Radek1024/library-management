import dao.AdminDao;
import dbUtils.Connect;
import pojo.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static Db.CreateDB.getConnectionos;

public class EditAdminTest {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.setName("admin123");
        admin.setEmail("admin@admin");
        admin.setId(1);
        try {
            Connection connection = getConnectionos();
            Statement st = connection.createStatement();
            String query = "UPDATE admin SET name='" +
                    admin.getName()+
                    "', email='"+
                    admin.getEmail()+
                    "' WHERE id='" +
                     admin.getId()+"'";
            st.execute(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        AdminDao dao = new AdminDao();
        System.out.println(dao.getAdmin());
    }
}
