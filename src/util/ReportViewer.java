package util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportViewer {

    
    public static void showReport(String reportName, Connection conn) {
        showReport(reportName, null, conn);
    }

    
    public static void showReport(String reportName, Map<String, Object> parameters, Connection conn) {
        try {
            InputStream reportStream = ReportViewer.class.getClassLoader().getResourceAsStream("reports/" + reportName + ".jasper");
            if (reportStream == null) {
                throw new RuntimeException("Report file not found in classpath: reports/" + reportName + ".jasper");
            }

            JasperReport jr = (JasperReport) JRLoader.loadObject(reportStream);

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
