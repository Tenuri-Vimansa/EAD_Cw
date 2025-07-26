/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Model.LoginModel;
import javax.swing.JOptionPane;
import view.Login;
import view.Home;
import view.RegisterForm;


/**
 *
 * @author Tenuri
 */
public class LoginController {
    
 private Login view;
    private LoginModel model;

    public LoginController(Login view, LoginModel model) {
        this.view = view;
        this.model = model;

        
        this.view.getLoginButton().addActionListener(e -> {
            System.out.println("Login button clicked");   
            try {
                validateLogin();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
            }
        });
        this.view.getRegisterButton().addActionListener(e -> openRegisterForm());

    }

    private void validateLogin() {
        System.out.println("Validating login...");
        String username = view.getUsernameField().getText().trim();
        String phone = view.getPhoneNumberField().getText().trim();
        String email = view.getEmailField().getText().trim();
        String password = new String(view.getPasswordField().getPassword()).trim();

        if (username.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "All fields are required.");
            return;
        }

        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(view, "Phone number must contain exactly 10 digits.");
            return;
        }

  
        boolean registered = model.isRegisteredUser(email, password);
        if (!registered) {
            JOptionPane.showMessageDialog(view, "First you should register.");
            return;
            
            
        }

        
        boolean saved = model.saveUser(username, phone, email, password);
        if (!saved) {
            JOptionPane.showMessageDialog(view, "Failed to save login info.");
            return;
        }

        JOptionPane.showMessageDialog(view, "Login successful!");

       
        Home homeView = new Home();
        new HomeController(homeView);
        homeView.setVisible(true);

       
        view.dispose();
    }
     private void openRegisterForm() {
    System.out.println("Register button clicked from Login form");

   
    view.dispose();

    
    RegisterForm registerForm = new RegisterForm();
    registerForm.setVisible(true);
}

    
}
