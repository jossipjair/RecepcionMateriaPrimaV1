package Controlador;

import BaseDeDatos.D_Consultas;
import java.io.File;
import javax.swing.JTable;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author jescalaya
 */
public class C_Consultas {

    public void llenarTabla(JTable tblImpresion, String fechaIncio, String fechaFin) {
        D_Consultas consulta = new D_Consultas();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int indexRow, int indexColumn) {
                return false;
            }
        };

        modelo.addColumn("P. BRUTO");
        modelo.addColumn("TARA");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("P. ENVASE");
        modelo.addColumn("P. TOTAL ENVASE");
        modelo.addColumn("P. NETO");
        modelo.addColumn("VIAJE");
        modelo.addColumn("LOTE");
        modelo.addColumn("VARIEDAD");
        modelo.addColumn("F. PESADO");
        modelo.addColumn("GUIA REMISION");
        modelo.addColumn("OBSERVACION");
        modelo.addColumn("F. PROCESO");

        for (int i = 0; i < consulta.llenarTablaReimpresion(fechaIncio, fechaFin).size(); i++) {
            modelo.addRow(consulta.llenarTablaReimpresion(fechaIncio, fechaFin).get(i));
        }
        tblImpresion.setModel(modelo);
    }

    public void generaExcelReimprimirPaleta(JTable tblDatos) throws IOException {

        String rutaArchivo = System.getProperty("user.home") + "/Recepcion Materia Prima.xls";
        File archivoXLS = new File(rutaArchivo);
        if (archivoXLS.exists()) {
            archivoXLS.delete();
        }
        archivoXLS.createNewFile();
        Workbook libro = new HSSFWorkbook();

        try (FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
            Sheet hoja = libro.createSheet("RECEPCION DETALLADO");

            for (int f = 0; f < tblDatos.getRowCount(); f++) {
                Row fila = hoja.createRow(f);
                for (int c = 0; c < tblDatos.getColumnCount(); c++) {
                    Cell celda = fila.createCell(c);
                    if (f == 0) {
                        celda.setCellValue(tblDatos.getColumnName(c));
                    } else {
                        celda.setCellValue(tblDatos.getValueAt(f, c).toString());
                    }
                }
            }
            libro.write(archivo);
        }
        Desktop.getDesktop().open(archivoXLS);
    }

}
