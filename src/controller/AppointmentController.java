package controller;

import model.Appointmentmodel;
import view.Appointment;
import view.Home;

import javax.swing.*;
import java.util.Date;

public class AppointmentController {

    private Appointment view;
    private Appointmentmodel model;

    public AppointmentController(Appointment view) {
        this.view = view;
        this.model = new Appointmentmodel();

        
        this.view.getCheckButton().addActionListener(e -> assignNumber());
        this.view.getConfirmButton().addActionListener(e -> confirmAppointment());
        this.view.getBackButton().addActionListener(e -> goBackToHome());
    }

    
private void assignNumber() {
    try {
        String doctor = (String) view.getDoctorComboBox().getSelectedItem();
        java.util.Date selectedDate = view.getDateChooser().getDate();

        if (doctor == null || selectedDate == null) {
            JOptionPane.showMessageDialog(view, "Please select a doctor and date first.");
            return;
        }

        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        int number = model.getNextAppointmentNumber(doctor, sqlDate);

        if (number != -1) {
            view.getAppointmentNumberField().setText(String.valueOf(number));
        } else {
            JOptionPane.showMessageDialog(view, "All 20 appointments are already booked for this doctor on this date.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(view, "Error assigning appointment number.");
    }
}


  
  private void confirmAppointment() {
    try {
        // Get user inputs
        String name = view.getPatientNameField().getText().trim();
        String ageText = view.getAgeField().getText().trim();
        String doctor = (String) view.getDoctorComboBox().getSelectedItem();
        String numberText = view.getAppointmentNumberField().getText().trim();

        
        if (name.isEmpty() || ageText.isEmpty() || numberText.isEmpty() || doctor == null) {
            JOptionPane.showMessageDialog(view, "Please fill in all fields before confirming.");
            return;
        }

        //  Convert age and appointment number
        int age = Integer.parseInt(ageText);
        int number = Integer.parseInt(numberText);

        //  Get date 
        java.util.Date selectedDate = view.getDateChooser().getDate();
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(view, "Please select an appointment date.");
            return;
        }

        
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

        
        boolean success = model.saveAppointment(name, age, doctor, number, sqlDate);

        
        if (success) {
            JOptionPane.showMessageDialog(view, "Appointment confirmed!");
        } else {
            JOptionPane.showMessageDialog(view, "Failed to confirm appointment. Please try again.");
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(view, "Please enter valid numeric values for age and appointment number.");
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(view, "Unexpected error: " + ex.getMessage());
    }
  }
        
    private void goBackToHome() {
        Home homeView = new Home();
        new HomeController(homeView);
        homeView.setVisible(true);
        view.dispose();
    }
}


