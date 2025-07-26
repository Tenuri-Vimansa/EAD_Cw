package model;

import java.sql.*;

public class DoctorModel {

public ResultSet getDoctorDetails(String doctorName) {
    ResultSet rs = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ead?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "root");
        String query = "SELECT * FROM doctor WHERE Name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, doctorName);
        rs = ps.executeQuery();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return rs;
}
}
