package Controlador;

import BaseDeDatos.D_DetalleRecepcionPalta;
import Entidad.E_DetalleRecepcionPalta;
import Entidad.E_RecepcionPalta;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class C_DetalleRecepcionPalta {

    D_DetalleRecepcionPalta dao;

    public String insertarDetalleRecepcionPalta(JTextField txtIdRecepcion, JLabel lblCodigoBarraNumerico, JTextField txtFechaHoraActual, JTextField txtTara, JTextField txtPesoBruto, JTextField txtCantidad,
            JTextField txtPeso, JTextField txtPesoTotal, JTextField txtPesoNeto, JCheckBox chkReproceso, JTextArea txtObservacion, JTextField txtidDetalleRecepcion, boolean operacion) {

        E_DetalleRecepcionPalta detalle = new E_DetalleRecepcionPalta();
        E_RecepcionPalta recepcion = new E_RecepcionPalta();
        dao = new D_DetalleRecepcionPalta();
        String mensaje = "";
        byte reproceso;

        /*//CONVIRTIENDO FECHA Y NUMERO
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaPesado = null;
        try {
            fechaPesado = formatoFecha.parse(txtFechaHoraActual.getText());
            JOptionPane.showMessageDialog(null, fechaPesado);
        } catch (ParseException ex) {
            Logger.getLogger(C_DetalleRecepcionPalta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, fechaPesado.toString());
        java.sql.Date sqlDate = new java.sql.Date(fechaPesado.getTime());
        JOptionPane.showMessageDialog(null, sqlDate.toString());*/
        recepcion.setIdRecepcionPalta(Integer.parseInt(txtIdRecepcion.getText().trim()));
        detalle.setRecepcionPalta(recepcion);
        detalle.setdRPalta_CoBar(lblCodigoBarraNumerico.getText().trim());
        detalle.setdRPalta_Fech_Pesa(txtFechaHoraActual.getText().trim());
        detalle.setdRPalta_Tara(Double.parseDouble(txtTara.getText().trim()));
        detalle.setdRPalta_Peso_Bruto(Double.parseDouble(txtPesoBruto.getText().trim()));
        detalle.setdRPalta_Canti(Integer.parseInt(txtCantidad.getText().trim()));
        detalle.setdRPalta_Peso(Double.parseDouble(txtPeso.getText().trim()));
        detalle.setdRPalta_PTota(Double.parseDouble(txtPesoTotal.getText().trim()));
        detalle.setdRPalta_PNeto(Double.parseDouble(txtPesoNeto.getText().trim()));

        if (chkReproceso.isSelected()) {
            reproceso = 1;
        } else {
            reproceso = 0;
        }
        detalle.setdRPalta_esReproceso(reproceso);
        detalle.setdRPalta_Observacion(txtObservacion.getText());
        detalle.setIdDetalleRecepcionPalta(Integer.parseInt(txtidDetalleRecepcion.getText()));

        //INSERTANDO O ACTUALIZANDO DETALLE RECEPCION
        if (operacion) {
            mensaje = dao.insertar(detalle);
        } else {
            mensaje = dao.actualizar(detalle);
        }
        return mensaje;
    }

    public String darBajaDetalleRecepcion(JTextField txtidDetalleRecepcion) {
        D_DetalleRecepcionPalta dDetalleRecepcionPalta = new D_DetalleRecepcionPalta();
        E_DetalleRecepcionPalta eDetalleRecepcionPalta = new E_DetalleRecepcionPalta();
        eDetalleRecepcionPalta.setIdDetalleRecepcionPalta(Integer.parseInt(txtidDetalleRecepcion.getText()));
        String mensaje = dDetalleRecepcionPalta.darBaja(eDetalleRecepcionPalta);

        return mensaje;
    }

    public void mostrarDetalleRecepcion(JTable tblDetalleRecepcionPalta, int idBuscarRecepcionPalta) {
        D_DetalleRecepcionPalta dDetalleRecepcionPalta = new D_DetalleRecepcionPalta();
        DefaultTableModel modeloDetalleRecepcionPalta = new DefaultTableModel(){
            
            @Override 
            public boolean isCellEditable(int indexRow, int indexColumn){
                return false;
            }
        };
        modeloDetalleRecepcionPalta.addColumn("ID");
        modeloDetalleRecepcionPalta.addColumn("FECHA PESADO");
        modeloDetalleRecepcionPalta.addColumn("P. BRUTO");
        modeloDetalleRecepcionPalta.addColumn("TARA");
        modeloDetalleRecepcionPalta.addColumn("CANT.");
        modeloDetalleRecepcionPalta.addColumn("PESO");
        modeloDetalleRecepcionPalta.addColumn("P. TOTAL");
        modeloDetalleRecepcionPalta.addColumn("P. NETO");
        modeloDetalleRecepcionPalta.addColumn("REPROCESO");
        modeloDetalleRecepcionPalta.addColumn("PROCESADO");
        modeloDetalleRecepcionPalta.addColumn("OBS");
        modeloDetalleRecepcionPalta.addColumn("F. PROCESO");
        modeloDetalleRecepcionPalta.addColumn("CODIGO QR");
        dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta);
        Object listaObjeto[] = new Object[13];
        for (int i = 0; i < dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).size(); i++) {
            listaObjeto[0] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getIdDetalleRecepcionPalta();
            listaObjeto[1] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Fech_Pesa();
            listaObjeto[2] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Peso_Bruto();
            listaObjeto[3] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Tara();
            listaObjeto[4] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Canti();
            listaObjeto[5] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Peso();
            listaObjeto[6] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_PTota();
            listaObjeto[7] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_PNeto();
            listaObjeto[8] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_esReproceso();
            listaObjeto[9] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_esProcesado();
            listaObjeto[10] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Observacion();
            listaObjeto[11] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_Fech_Proc();
            listaObjeto[12] = dDetalleRecepcionPalta.listarBusquedaRegistro(idBuscarRecepcionPalta).get(i).getdRPalta_CoBar();
            modeloDetalleRecepcionPalta.addRow(listaObjeto);
        }
        tblDetalleRecepcionPalta.setModel(modeloDetalleRecepcionPalta);
    }
}
