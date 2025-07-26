/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Tenuri
 */

package controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import model.DBConnection;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportController {

    public void showReport() {
        try {
           
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile("src/reports/MyReport.jasper");

            // Get database connection
            Connection con = DBConnection.getConnection();

          
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

           
            JasperViewer.viewReport(jp, false);  

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
