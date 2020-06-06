package servlets.admin;

import dao.AdminDao;
import pojo.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAdmin", urlPatterns = {"/EditAdmin"})
public class EditAdmin extends HttpServlet {
    Admin admin = new Admin();
    AdminDao dao = new AdminDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));

        admin.setName(name);
        admin.setEmail(email);
        admin.setId(id);
        dao.editAdmin(admin);
        request.getRequestDispatcher("/AdminSession").forward(request,response);

        /*String path = request.getServletPath();
        if (path.equals("/edit")){
            edit(request,response);
        }else if (path.equals("/getId")){
            getById(request,response);
        }*/
    }
    /*private void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("dao", dao.getAdminById(id));
        request.getRequestDispatcher("EditAdmin.jsp").forward(request, response);

    }
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }*/

}
