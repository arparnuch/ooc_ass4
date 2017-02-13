package servlet;

import io.muic.ooc.assigment4.MySQLJava;
import io.muic.ooc.assigment4.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by arparnuch on 2/13/2017 AD.
 */
//@WebServlet(
//        name = "UserServlet",
//        urlPatterns = {"/users"}
//)
public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Enter Get in UserServlet");
//        MySQLJava DB = new MySQLJava();
//        ArrayList<User> userArrayList = new ArrayList<>();
//        DB.connectDatabase();
//        try {
//            DB.queryData("SELECT * FROM ooc_webapp.accessTable");
//            userArrayList = DB.getListOfUsers();
//            req.setAttribute("userArrayList", userArrayList);
//            req.getRequestDispatcher("/userList.jsp").forward(req,resp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("DB FAIL");
//        }finally {
////            req.setAttribute("userArrayList", userArrayList);
////            req.getRequestDispatcher("userList.jsp").forward(req,resp);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Enter Post");




    }


}
