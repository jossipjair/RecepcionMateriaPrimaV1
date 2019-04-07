
package Reporte;

import Controlador.C_CodigoQR;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Android
 */
public class rptImprimeTarja {
    
    public void llenarReporte(int idReporte, String codigoBarra){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("rpImprimeTarja.jasper");
            Map parametro = new HashMap();         
            parametro.put("idRecepcion", idReporte);
            //JOptionPane.showMessageDialog(null, codigoBarra);
            String archivo = "C:\\ControlRecepcion\\dist\\img\\"+codigoBarra+".gif";
            parametro.put("codeQR",archivo);
            JasperPrint j = JasperFillManager.fillReport(reporte, parametro, Conexion.Conexion.getInstancia().getConexion());
            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("Imprime Tarja Detalle Recepción");
            jv.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir Tarja\n" + e);
        }
    }
}

















           //String archivo = "/img/" + codigoBarra + ".png";
           //String archivo = System.getProperty("user.home") + "\\" + codigoBarra + ".png";
            //String archivo =  "E:\\15-05\\pryControlRecepcion\\img\\" + codigoBarra + ".gif";
            //String archivo = "C:\\ControlRecepcion\\imgQR\\" + codigoBarra + ".gif";
           //JOptionPane.showMessageDialog(null, archivo);
