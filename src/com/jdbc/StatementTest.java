package com.jdbc;

import java.sql.*;

/**
 * Created by Fant.J.
 * 2018/3/1 13:41
 */
public class StatementTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user";

// mysql数据库的用户名与密码，安装时自己设置，一般默认为root
        String user = "root";
        String password = "root";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.加载驱动//com.mysql.jdbc.Driver
    /*
     * DriverManager.registerDriver(new
     * Driver());用这种方法会加载两次驱动，也就是说会创建两个drive对象
     */
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            connection = DriverManager.getConnection(url, user, password);

            // 3.获取用于向数据库发送SQL的Statement对象
            statement = connection.createStatement();

            // 4.执行sql,获取数据
            resultSet = statement.executeQuery("SELECT * FROM user;");

            // 解析数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String birthday = resultSet.getString("birthday");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");

                System.out.println(" " + username + " " + birthday + " " + sex
                        + " " + address);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //5.关闭连接，释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                resultSet = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                statement = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                connection = null;
            }
        }
    }
}
