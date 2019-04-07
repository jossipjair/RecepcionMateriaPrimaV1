package Controlador;

import BaseDeDatos.D_Cultivo;
import Entidad.E_Cultivo;
import Entidad.E_Estado;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class C_Cultivo {

    private String mensaje;

    public String insertarCultivo(JTextField txtIdCultivo, JTextField txtDescripcion, boolean guardar) {
        //CREACION DE OBJETOS
        D_Cultivo dCultivo = new D_Cultivo();
        E_Cultivo eCultivo = new E_Cultivo();
        E_Estado eEstado = new E_Estado();

        //ASIGNACION DE VARIABLES A OBJETOS
        eCultivo.setCult_Descr(txtDescripcion.getText());
        eCultivo.setIdCultivo(Integer.parseInt(txtIdCultivo.getText()));
        eEstado.setIdEstado(1);
        eEstado.setEsta_Descr("ACTIVO");
        eCultivo.setIdEstado(eEstado);

        //INSERSION DE DATOS
        if (guardar) {
            mensaje = dCultivo.insertar(eCultivo);
        } else {
            mensaje = dCultivo.actualizar(eCultivo);
        }
        return mensaje;
    }

    public String darBajaCultivo(JTextField txtIdCultivo, JLabel lblEstado) {
        D_Cultivo dCultivo = new D_Cultivo();
        E_Cultivo eCultivo = new E_Cultivo();
        E_Estado eEstado = new E_Estado();

        if (lblEstado.equals("ACTIVO")) {
            eEstado.setIdEstado(2); //REGISTRO INACTIVO
            eCultivo.setIdEstado(eEstado);
        } else {
            eEstado.setIdEstado(1); //REGISTRO ACTIVO
            eCultivo.setIdEstado(eEstado);
        }
        return mensaje = dCultivo.darBaja(eCultivo);
    }

    public void mostrarCultivos(JTable tblDatos) {
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int indexRow, int indexColumn){
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("CULTIVO");
        modelo.addColumn("ESTADO");
        D_Cultivo dCultivo = new D_Cultivo();
        dCultivo.listarRegitrosObject();

        for (int i = 0; i < dCultivo.listarRegitrosObject().size(); i++) {
            modelo.addRow(dCultivo.listarRegitrosObject().get(i));
        }
        tblDatos.setModel(modelo);
    }

    public void llenarComboCultivo(JComboBox<E_Cultivo> cboCultivo) {
        D_Cultivo dCultivo = new D_Cultivo();
        E_Cultivo eCultivo = new E_Cultivo();
        for (int i = 0; i < dCultivo.listarRegistros().size(); i++) {
            eCultivo = dCultivo.listarRegistros().get(i);
            cboCultivo.addItem(eCultivo);
        }

    }
}
