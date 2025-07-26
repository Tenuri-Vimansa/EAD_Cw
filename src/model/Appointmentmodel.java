/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author Tenuri
 */
public class Appointmentmodel {

 public int getNextAppointmentNumber(String doctor, java.sql.Date date) {
    int count = 0;
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ead?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "root");
        String sql = "SELECT COUNT(*) FROM drappointment WHERE Doctor = ? AND `Date` = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, doctor);
        stmt.setDate(2, date);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }

        conn.close();

        return (count < 20) ? (count + 1) : -1; // Max 20 per doctor per day

    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}


    public boolean saveAppointment(String name, int age, String doctor, int number, java.sql.Date date ) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ead?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "root");
            String sql = "INSERT INTO drappointment (PatientName, Age, Doctor,Date, Apnumber) VALUES (?, ?, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, doctor);
            stmt.setDate(4, date);
            stmt.setInt(5,number);
            stmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
