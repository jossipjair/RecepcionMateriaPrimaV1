package Controlador;

import BaseDeDatos.D_RecepcionPalta;
import Entidad.E_Estado;
import Entidad.E_Lote;
import Entidad.E_RecepcionPalta;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class C_RecepcionPalta {

    D_RecepcionPalta dao;

    public String insertarRecepcionPalta(int idLote, int idEstado, JTextField dtcFechaRegistro, JTextField txtGuiaRemision, JComboBox cboViaje, JTextArea txtObservacion, JTextField txtidRecepcion, boolean tipoGuardado) {
        E_RecepcionPalta recepcionPalta = new E_RecepcionPalta();
        E_Lote lote = new E_Lote();
        E_Estado estado = new E_Estado();
        dao = new D_RecepcionPalta();
        String mensaje = "";

        lote.setIdLote(idLote);
        estado.setIdEstado(idEstado);
        recepcionPalta.setEstado(estado);
        recepcionPalta.setLote(lote);

        /*
        //CONVIRTIENDO FECHA Y NUMERO
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaPesado = null;
        try {
            fechaPesado = formatoFecha.parse(dtcFechaRegistro.getText());
        } catch (ParseException ex) {
            Logger.getLogger(C_DetalleRecepcionPalta.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Conversion a SQLDATE
        java.util.Date utilDate = fechaPesado;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        */
        recepcionPalta.setrPalta_FechRegistro(dtcFechaRegistro.getText());
        recepcionPalta.setrPalta_Guia_Remis(txtGuiaRemision.getText());
        recepcionPalta.setrPalta_Obser(txtObservacion.getText());
        recepcionPalta.setrPalta_Viaje(cboViaje.getSelectedItem().toString());
        recepcionPalta.setIdRecepcionPalta(Integer.parseInt(txtidRecepcion.getText()));
        if (tipoGuardado) {
            mensaje = dao.insertar(recepcionPalta);
        } else {
            mensaje = dao.actualizar(recepcionPalta);
        }

        return mensaje;
    }

    /*
    public void actualizarRecepcionPalta(int idLote, int idEstado, JDateChooser dtcFechaRegistro, JTextField txtGuiaRemision, JComboBox cboViaje, JTextArea txtObservacion, JTextField txtidRecepcion) {
        E_RecepcionPalta recepcionPalta = new E_RecepcionPalta();
        E_Lote lote = new E_Lote();
        dao = new D_RecepcionPalta();

        lote.setIdLote(idLote);
        recepcionPalta.setLote(lote);

        //Conversion a SQLDATE
        java.util.Date utilDate = dtcFechaRegistro.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        recepcionPalta.setrPalta_FechRegistro(sqlDate);
        recepcionPalta.setrPalta_Guia_Remis(txtGuiaRemision.getText());
        recepcionPalta.setrPalta_Obser(txtObservacion.getText());
        recepcionPalta.setrPalta_Viaje(cboViaje.getSelectedItem().toString());
        recepcionPalta.setIdRecepcionPalta(Integer.parseInt(txtidRecepcion.getText()));
        String mensaje = dao.actualizar(recepcionPalta);
        JOptionPane.showMessageDialog(null, mensaje);
    }*/

    public void llenarGridRecepcionPalta(JTable tblRecepcionPalta) {
        dao = new D_RecepcionPalta();
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int indexRow, int indexColumn){
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("LOTE");
        modelo.addColumn("VARIEDAD");
        modelo.addColumn("FECHA REGISTRO");
        modelo.addColumn("GUIA REMISION");
        modelo.addColumn("VIAJE");
        modelo.addColumn("OBSERVACION");

        for (int i = 0; i < dao.listarRegitrosObject().size(); i++) {
            modelo.addRow(dao.listarRegitrosObject().get(i));
        }
        tblRecepcionPalta.setModel(modelo);

    }

}
