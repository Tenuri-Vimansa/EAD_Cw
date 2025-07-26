package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DBConnection; 
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class LoginModel {
    
    public boolean saveUser(String username, String phone, String email, String password) {
        String query = "INSERT INTO hlogin (Username, Telno, Email, Password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.setString(4, password);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean isRegisteredUser(String email, String password) {
    String sql = "SELECT * FROM register WHERE email = ? AND password = ?";
    try {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    } catch (Exception e) {  
        e.printStackTrace();
        return false;
    }
}



}
