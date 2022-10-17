package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
//    public static void main(String[] args) {
//        System.out.println(DBConnect.getDB());
//    }

    public static Connection getDB() {
        Connection connect = null;
        String url = "jdbc:mysql://localhost:3306/guess_number";
        String user = "root";
        String password = "qQq999123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connect;
    }
}
