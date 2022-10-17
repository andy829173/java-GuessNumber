package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class implLogin implements loginDao {

    @Override
    public boolean query(String username, String password) {
        boolean exist = false;
        Connection connect = DBConnect.getDB();
        String sql = "SELECT * FROM member WHERE username = ? AND password = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            } else {
                exist = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exist;
    }
}
