package controller;

import view.Docdetails;
import model.DoctorModel;
import view.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DocdetailsController {

    private Docdetails view;
    private DoctorModel model;

    public DocdetailsController(Docdetails view) {
        this.view = view;
        this.model = new DoctorModel();  

       
        view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch(); 
            }
        });

      
        view.getBacktoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToHome();
            }
        });
    }

    private void performSearch() {
        String selectedDoctor = (String) view.getDoctorNameComboBox().getSelectedItem();
        System.out.println("Selected doctor: " + selectedDoctor); 

        try {
            ResultSet rs = model.getDoctorDetails(selectedDoctor);
            if (rs.next()) {
                System.out.println("Doctor found. Loading data...");
                view.getSpecialtyField().setText(rs.getString("speciality"));
                view.getHospitalField().setText(rs.getString("Hospital"));
                view.getExperienceField().setText(rs.getString("Experience"));
            } else {
                JOptionPane.showMessageDialog(view, "No details found for the selected doctor.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
        }
    }

    private void goBackToHome() {
        Home homeView = new Home();
        new HomeController(homeView);
        homeView.setVisible(true);
        view.dispose();
    }
}

