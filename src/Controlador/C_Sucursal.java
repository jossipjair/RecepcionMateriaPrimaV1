package Controlador;

import BaseDeDatos.D_Sucursal;
import Entidad.E_Empresa;
import Entidad.E_Estado;
import Entidad.E_Sucursal;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class C_Sucursal {

    private String mensaje;

    public String insertarSucursal(JTextField txtIdSucursal, JTextField txtDescripcion, int idEmpresa, boolean guardar) {
        //CREACION DE OBJETOS
        D_Sucursal dSucursal = new D_Sucursal();
        E_Sucursal eSucursal = new E_Sucursal();
        E_Empresa eEmpresa = new E_Empresa();
        E_Estado eEstado = new E_Estado();
        //ASIGNACION DE VARIABLES A OBJETOS
        eSucursal.setSucu_Descr(txtDescripcion.getText());
        eSucursal.setIdSucursal(Integer.parseInt(txtIdSucursal.getText()));
        eEmpresa.setIdEmpresa(idEmpresa);
        eSucursal.setIdEmpresa(eEmpresa);

        eEstado.setIdEstado(1);
        eEstado.setEsta_Descr("ACTIVO");
        eSucursal.setIdEstado(eEstado);

        //INSERSION DE DATOS
        if (guardar) {
            mensaje = dSucursal.insertar(eSucursal);
        } else {
            mensaje = dSucursal.actualizar(eSucursal);
        }
        return mensaje;
    }

    public String darBajaSucursal(JTextField txtIdCultivo, JLabel lblEstado) {
        D_Sucursal dSucursal = new D_Sucursal();
        E_Sucursal eSucursal = new E_Sucursal();
        E_Estado eEstado = new E_Estado();

        if (lblEstado.equals("ACTIVO")) {
            eEstado.setIdEstado(2); //REGISTRO INACTIVO
            eSucursal.setIdEstado(eEstado);
        } else {
            eEstado.setIdEstado(1); //REGISTRO ACTIVO
            eSucursal.setIdEstado(eEstado);
        }
        return mensaje = dSucursal.darBaja(eSucursal);
    }

    public void mostrarSucursal(JTable tblDatos) {
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int indexRow, int indexColumn){
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("EMPRESA");
        modelo.addColumn("SUCURSAL");

        modelo.addColumn("ESTADO");
        D_Sucursal dSucursal = new D_Sucursal();
        dSucursal.listarRegitrosObject();

        for (int i = 0; i < dSucursal.listarRegitrosObject().size(); i++) {
            modelo.addRow(dSucursal.listarRegitrosObject().get(i));
        }
        tblDatos.setModel(modelo);
    }

    public void llenarComboSucursal(JComboBox<E_Sucursal> cboSucursal) {
        D_Sucursal dSucursal = new D_Sucursal();
        E_Sucursal eSucursal = new E_Sucursal();
        for (int i = 0; i < dSucursal.listarRegistros().size(); i++) {
            eSucursal = dSucursal.listarRegistros().get(i);
            cboSucursal.addItem(eSucursal);
        }

    }
}
