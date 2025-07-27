/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DashboardModel {

    public int countAppointmentsForDate(java.sql.Date date) {
        int count = 0;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM drappointment WHERE Date = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int countAvailableDoctors() {
   
        return 5;
    }

    public DefaultTableModel getAppointmentsForDate(java.sql.Date date) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Appointment No", "Patient Name", "Doctor Name", "Date"}, 0);
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT Apnumber, PatientName, Doctor, Date FROM drappointment WHERE Date = ?ORDER BY Apnumber ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("Apnumber"),
                    rs.getString("PatientName"),
                    rs.getString("Doctor"),
                    rs.getDate("Date")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
