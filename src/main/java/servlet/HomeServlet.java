package servlet;

/**
 * Created by arparnuch on 2/12/2017 AD.
 */
import io.muic.ooc.assigment4.MySQLJava;
import io.muic.ooc.assigment4.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

@WebServlet(
        name = "HomeServlet",
        urlPatterns = {"/"}
)
public class HomeServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Enter");
        String UserUsername = request.getParameter("username");
        String UserPassword = request.getParameter("password");
//        RequestDispatcher rd = null;

        ServletOutputStream out = response.getOutputStream();
//        out.print(UserUsername + " " + UserPassword);

        MySQLJava database = new MySQLJava();
        User user = new User(UserUsername,UserPassword,null);
        try {
            database.connectDatabase();
            database.queryData("SELECT * FROM ooc_webapp.accessTable");

            boolean isIn = database.readData("login", user);
            if (isIn){
                user.setAuthen(true);
                response.sendRedirect("usersList.jsp");
            }
            else{
                JOptionPane.showMessageDialog(null, "Fail to Login!");
                response.sendRedirect("index.jsp"); // login page
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }

    }

}
