package com.jdbc;

import java.sql.*;

/**
 * Created by Fant.J.
 * 2018/3/5 20:14
 */
public class CallableStatementTest {
    static String url = "jdbc:mysql://localhost:3306/user";
    static String user = "root";
    static String password = "root";

    public static void main(String[] args) {


        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            String sql = "CALL findById(?)";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1,27);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String birthday = resultSet.getString("birthday");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");

                System.out.println("  " + username + "  " + birthday + " " + sex
                        + " " + address);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
