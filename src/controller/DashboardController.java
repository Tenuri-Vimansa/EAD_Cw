/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Dashboard;
import model.DashboardModel;
import view.Appointment;
import view.Doctor;
import view.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

public class DashboardController {

    private Dashboard view;
    private DashboardModel model;

    public DashboardController(Dashboard view) {
        this.view = view;
        this.model = new DashboardModel();

       
        view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDashboardSearch();
            }
        });

      
        view.getUpdateButton().addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        performDashboardSearch(); 
    }
});
            view.getbackToButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToHome();
            }
        });

              
        view.getAppointmentButton().addActionListener(e -> openAppointment());
        view.getDoctorButton().addActionListener(e -> openDoctor());
        view.getExitButton().addActionListener(e -> exitApplication());
    }
    
     // Opens Appointment frame
    private void openAppointment() {
        Appointment appointmentView = new Appointment();
        new AppointmentController(appointmentView);
        appointmentView.setVisible(true);
        view.dispose();  // closes current Dashboard window
    }

    // Opens Doctor frame
    private void openDoctor() {
        Doctor doctorView = new Doctor();
        new DoctorController(doctorView);
        doctorView.setVisible(true);
        view.dispose();
    }

    // Exit application
    private void exitApplication() {
        int confirm = JOptionPane.showConfirmDialog(view, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
/*
    private void performDashboardSearch() {
        java.util.Date selectedDate = view.getDateChooser().getDate();
        if (selectedDate == null) {
            view.showMessage("Please select a date.");
            return;
        }

        java.sql.Date sqlDate = new Date(selectedDate.getTime());

        int appointmentCount = model.countAppointmentsForDate(sqlDate);
        int availableDoctors = model.countAvailableDoctors();

        view.setAppointmentCount(String.valueOf(appointmentCount));
        view.setAvailableDoctors(String.valueOf(availableDoctors));
        view.setAppointmentTable(model.getAppointmentsForDate(sqlDate));
    }*/
    private void performDashboardSearch() {
    java.util.Date selectedDate = view.getDateChooser().getDate();
    if (selectedDate == null) {
        view.showMessage("Please select a date.");
        return;
    }

    System.out.println("Update button clicked, fetching data...");

    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

    int appointmentCount = model.countAppointmentsForDate(sqlDate);
    int availableDoctors = model.countAvailableDoctors();

    System.out.println("Appointments: " + appointmentCount + ", Doctors: " + availableDoctors);

    
    view.setAvailableDoctors(String.valueOf(availableDoctors));
    view.setAppointmentTable(model.getAppointmentsForDate(sqlDate)); 
}
    
        private void goBackToHome() {
        Home homeView = new Home();
        new HomeController(homeView);
        homeView.setVisible(true);
        view.dispose();
    }

}
