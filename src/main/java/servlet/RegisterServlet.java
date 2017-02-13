package servlet;

import io.muic.ooc.assigment4.MySQLJava;
import io.muic.ooc.assigment4.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Statement;

/**
 * Created by arparnuch on 2/12/2017 AD.
 */
@WebServlet(
        name = "RegisterServlet",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserUsername = req.getParameter("username");
        String UserPassword = req.getParameter("password");
        String UserFirstname = req.getParameter("firstname");
        String UserLastname = req.getParameter("lastname");
        String UserEmail = req.getParameter("email");
        System.out.println("INFO SEND");
        MySQLJava mySQLJava = new MySQLJava();
        mySQLJava.connectDatabase();

        boolean flag = false;
        try {
            flag = mySQLJava.readData("register",new User(UserUsername,UserPassword,null,UserFirstname, UserLastname,UserEmail));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag){
            System.out.println("Update auto");
            resp.sendRedirect("index.jsp");
        }
        else System.out.println("Fail");



    }
}
