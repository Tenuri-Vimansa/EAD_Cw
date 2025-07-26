package controller;

import model.DBConnection;
import view.Home;
import view.Appointment;
import view.Doctor;
import view.Dashboard;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.ReportViewer;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.*;


public class HomeController {
    private Home view;

    public HomeController(Home view) {
        this.view = view;

        System.out.println("Home controller is connected");

        // Appointment Button
        view.getBtnappointment().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Appointment button clicked");
                openAppointment();
            }
        });

        // Doctor Button
        view.getDoctorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Doctor button clicked");
                openDoctor();
            }
        });

        // Dashboard Button
        view.getDashboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Dashboard button clicked");
                openDashboard();
            }
        });
        
        view.getReportButton().addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        openReport();
    }
});

    }

    // Open Appointment
    private void openAppointment() {
        Appointment appointmentView = new Appointment();          
        new AppointmentController(appointmentView);               
        appointmentView.setVisible(true);                         
        view.dispose();                                           
    }

    // Open Doctor
    private void openDoctor() {
        Doctor doctorView = new Doctor();
        new DoctorController(doctorView); 
        doctorView.setVisible(true);
        view.dispose();
    }

    // Open Dashboard 
  
    private void openDashboard() {
    view.getDashboardButton().setBackground(Color.GREEN); 

    Dashboard dashboardView = new Dashboard();             
    new DashboardController(dashboardView);                

    dashboardView.setVisible(true);                        
    view.dispose();                                        
}
private void openReport() {
    try {
        String reportPath = "appointmentdoc"; 
        Connection con = DBConnection.getConnection();
        HashMap<String, Object> parameters = new HashMap<>();
      

        ReportViewer.showReport(reportPath, parameters, con);  

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(view, "Error opening report: " + ex.getMessage());
    }
}



}


