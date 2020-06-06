import dao.AdminDao;
import pojo.Admin;

import java.util.Optional;

public class GetAdminByIdTest {
    public static void main(String[] args) {
        AdminDao dao = new AdminDao();
        Optional<String> optionalAdmin = Optional.ofNullable(dao.getAdminById(100).getEmail());
        System.out.println(optionalAdmin.isPresent());
        optionalAdmin.ifPresent(System.out::print);
    }
}
