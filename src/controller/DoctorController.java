package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Doctor;
import view.Docdetails; 

public class DoctorController {

    private Doctor view;

    public DoctorController(Doctor view) {
        this.view = view;
        this.view.setVisible(true);

       
        this.view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSearchForm();
            }
        });
    }

    // ✅ Method to open the Search form
   private void openSearchForm() {
    Docdetails searchView = new Docdetails();            
    new DocdetailsController(searchView);              
    searchView.setVisible(true);                        
    view.dispose();                                      
}

}
