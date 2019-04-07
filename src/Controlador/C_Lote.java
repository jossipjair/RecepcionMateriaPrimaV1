
package Controlador;

import BaseDeDatos.D_Lote;
import Entidad.E_Estado;
import Entidad.E_Lote;
import Entidad.E_Sucursal;
import Entidad.E_Variedad;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class C_Lote {

    public void llenarComboLote(JComboBox<E_Lote> cboLote) {
        E_Lote lote = new E_Lote();
        D_Lote dlote = new D_Lote();
        for (int i = 0; i < dlote.listarRegistros().size(); i++) {
            lote = dlote.listarRegistros().get(i);
            cboLote.addItem(lote);
        }
    }
     private String mensaje;
     
    public String insertarLote(JTextField txtidLote, int idSucursal, int idVariedad, JTextField txtLoteNombreCorto, JTextField txtLoteNombreLargo, boolean guardar) {
        //CREACION DE OBJETOS
        D_Lote dLote = new D_Lote();
        E_Lote eLote = new E_Lote();
        E_Estado eEstado = new E_Estado();
        E_Variedad eVariedad = new E_Variedad();
        E_Sucursal eSucursal = new E_Sucursal();

        //ASIGNACION DE VARIABLES A OBJETOS
        eLote.setIdLote(Integer.parseInt(txtidLote.getText()));
        eSucursal.setIdSucursal(idSucursal);
        eLote.setIdSucursal(eSucursal);
        eVariedad.setIdVariedad(idVariedad);
        eLote.setIdVariedad(eVariedad);
        eLote.setLote_NCort(txtLoteNombreCorto.getText());
        eLote.setLote_Descr(txtLoteNombreLargo.getText());
        eEstado.setIdEstado(1);
        eEstado.setEsta_Descr("ACTIVO");
        eLote.setIdEstado(eEstado);

        //INSERSION DE DATOS
        if (guardar) {
            mensaje = dLote.insertar(eLote);
        } else {
            mensaje = dLote.actualizar(eLote);
        }
        return mensaje;
    }

    public String darBajaLote(JTextField txtidLote, JLabel lblEstado) {
        D_Lote dLote = new D_Lote();
        E_Lote eLote = new E_Lote();
        E_Estado eEstado = new E_Estado();

        if (lblEstado.equals("ACTIVO")) {
            eEstado.setIdEstado(2); //REGISTRO INACTIVO
            eLote.setIdEstado(eEstado);
        } else {
            eEstado.setIdEstado(1); //REGISTRO ACTIVO
            eLote.setIdEstado(eEstado);
        }
        return mensaje = dLote.darBaja(eLote);
    }

    public void mostrarLote(JTable tblDatos) {
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int indexRow,int indexColumn){
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("SUCURSAL");
        modelo.addColumn("VARIEDAD");
        modelo.addColumn("LOTE NLARGO");
        modelo.addColumn("LOTE NCORTO");
        modelo.addColumn("ESTADO");
        D_Lote dLote = new D_Lote();
        dLote.listarRegitrosObject();

        for (int i = 0; i < dLote.listarRegitrosObject().size(); i++) {
            modelo.addRow(dLote.listarRegitrosObject().get(i));
        }
        tblDatos.setModel(modelo);
    }

}
