package io.muic.ooc.assigment4;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class MySQLJava {

    enum TestTableColumns {
        id, TEXT;
    }

    private final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    private final String jdbcURL = "jdbc:mysql://localhost:3306/ooc_webapp?useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "arparnuchACT4629";




    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public MySQLJava() {
        super();
    }

    public Statement connectDatabase() {
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(jdbcURL, USER, PASS);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("SQL Error");

        }finally {
            return statement;
        }
    }

    public void queryData(String sql){

        try {
            resultSet = statement.executeQuery(sql);
//            System.out.println(resultSet.next());
        } catch (SQLException e) {
            System.out.println("SQL Error");
        }


    }

    public boolean readData(String mode, User user) throws Exception {
        boolean flag;
//        statement.executeQuery("SELECT * FROM ooc_webapp.accessTable");
        flag = getResultSet(resultSet, mode, user);
//            preparedStatement = connection.prepareStatement("insert into ooc_webapp.accessTable values (default,?)");
//            preparedStatement.setString(1, "insert test from java");
//            preparedStatement.executeUpdate();

        close();
       return flag;

    }

    public boolean insertData(String mode ,User user) throws Exception{
        boolean flag = false;

        return flag;
    }

    private boolean getResultSet(ResultSet resultSet, String mode, User user) throws Exception {
        int id;
        String username;
        String password;

        if (mode.equals("login")){
            while (resultSet.next()) {
                username = resultSet.getString("USERNAME");
                password = resultSet.getString("PASSWORD");

                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    return true;
                }

            }
            return false;
        }


        return false;


    }



    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}
