package io.muic.ooc.assigment4;

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
            System.out.println("Connect To Database ...");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (SQLException e) {


            System.out.println("SQL Error");

        }finally {

            return statement;
        }
    }

    public void queryData(String sql){

        try {
            resultSet = statement.executeQuery(sql);

            System.out.println("Querying sql ...");
        } catch (SQLException e) {
            System.out.println("SQL Error");
        }


    }

    public boolean readData(String mode, User user) throws Exception {
        boolean flag = false;
//        statement.executeQuery();
        System.out.println("Read data ...");
        if (mode.equals("login")){
            System.out.println("Login");
            flag = isValidUser(resultSet, user);
        }
        else if (mode.equals("register")){
            System.out.println("Register");
            flag = insertData(user);
        }

        close();
       return flag;

    }

    public boolean insertData(User user) {
        boolean flag = true;
        try {
            System.out.println("INSERTing ..");
            System.out.println(user.getFirstname());
            preparedStatement = connection.prepareStatement("INSERT INTO ooc_webapp.accessTable (USERNAME, PASSWORD, FIRSTNAME, SURNAME, EMAIL) VALUES (?,?,?,?,?)");
            System.out.println("pass pre");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Database UPDATED!");
        } catch (SQLException e) {
            flag = !flag;
            System.out.println("SQL FAIL!!");
            System.out.println(e.getMessage());
        }finally {
            return flag;
        }


    }

    public ArrayList<User> getListOfUsers() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        int id;
        String username;
        String password;
        String firstname;
        String surname;
        String email;
        System.out.println("Enter getList");
        while (resultSet.next()) {
            username = resultSet.getString("USERNAME");
            password = resultSet.getString("PASSWORD");
            firstname = resultSet.getString("FIRSTNAME");
            surname = resultSet.getString("SURNAME");
            email = resultSet.getString("EMAIL");
            System.out.println(username);
            users.add(new User(username,password,null,firstname,surname,email));



        }

        return users;
    }
    private boolean isValidUser(ResultSet resultSet, User user) throws Exception {
        int id;
        String username;
        String password;

        System.out.println("Enter isValid");
        while (resultSet.next()) {
            username = resultSet.getString("USERNAME");
            password = resultSet.getString("PASSWORD");

            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }

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

            if (preparedStatement != null){
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}
