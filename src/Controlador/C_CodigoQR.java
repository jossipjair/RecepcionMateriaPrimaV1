package Controlador;

import com.barcodelib.barcode.QRCode;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jescalaya
 */
public class C_CodigoQR {

    private final int udm = 0;
    private final int resol = 72;
    private final int rot = 0;
    private final float mi = 0.000f;
    private final float md = 0.000f;
    private final float ms = 0.000f;
    private final float min = 0.000f;
    private final float tam = 9.00f;
    QRCode c = new QRCode();

    public void generarQr(String codigoBarra, String datosPaleta, JLabel lblCodigoQr) {
        try {
         
            String generarNuevoDato = datosPaleta;
            c.setData(generarNuevoDato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resol);
            c.setRotate(rot);
            c.setModuleSize(tam);
            BufferedImage img = new BufferedImage(300, 100, BufferedImage.TYPE_INT_ARGB);
            img = c.renderBarcode();
            ImageIcon icono = new ImageIcon(img);
            lblCodigoQr.setIcon(icono);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void renderizarImagenQR(String codigoBarra, String datosPaleta) {
        //String archivo = "E:\\15-05\\pryControlRecepcion\\src\\img\\" + codigoBarra + ".gif";// DESDE NETBEANS
        String archivo = "C:\\ControlRecepcion\\dist\\img\\" + codigoBarra + ".gif"; //DESDE DISTRIBUCION
        //String archivo = java.lang.System.getProperty("user.dir")+"/"+ codigoBarra + ".gif";
        try {
            String generarNuevoDato = datosPaleta;
            c.setData(generarNuevoDato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resol);
            c.setRotate(rot);
            c.setModuleSize(tam);
            c.renderBarcode(archivo);
        } catch (Exception ex) {
            Logger.getLogger(C_CodigoQR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
