    package Controlador;

import BaseDeDatos.D_Empresa;
import Entidad.E_Empresa;
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
public class C_Empresa {

    private String mensaje;

    public String insertarEmpresa(JTextField txtIdEmpresa, JTextField txtDescripcion, boolean guardar) {
        //CREACION DE OBJETOS
        D_Empresa dEmpresa = new D_Empresa();
        E_Empresa eEmpresa = new E_Empresa();
        E_Estado eEstado = new E_Estado();

        //ASIGNACION DE VARIABLES A OBJETOS
        eEmpresa.setIdEmpresa(Integer.parseInt(txtIdEmpresa.getText()));
        eEmpresa.setEmpr_Descr(txtDescripcion.getText());
        eEstado.setIdEstado(1);
        eEstado.setEsta_Descr("ACTIVO");
        eEmpresa.setIdEstado(eEstado);

        //INSERSION DE DATOS
        if (guardar) {
            mensaje = dEmpresa.insertar(eEmpresa);
        } else {
            mensaje = dEmpresa.actualizar(eEmpresa);
        }
        return mensaje;
    }

    public String darBajaEmpresa(JTextField txtIdEmpresa, JLabel lblEstado) {
        D_Empresa dEmpresa = new D_Empresa();
        E_Empresa eEmpresa = new E_Empresa();
        E_Estado eEstado = new E_Estado();

        if (lblEstado.equals("ACTIVO")) {
            eEstado.setIdEstado(2); //REGISTRO INACTIVO
            eEmpresa.setIdEstado(eEstado);
        } else {
            eEstado.setIdEstado(1); //REGISTRO ACTIVO
            eEmpresa.setIdEstado(eEstado);
        }
        return mensaje = dEmpresa.darBaja(eEmpresa);
    }

    public void mostrarEmpresa(JTable tblDatos) {
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int indexRow, int indexColumn){
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("EMPRESA");
        modelo.addColumn("ESTADO");
        D_Empresa dEmpresa = new D_Empresa();
        dEmpresa.listarRegitrosObject();

        for (int i = 0; i < dEmpresa.listarRegitrosObject().size(); i++) {
            modelo.addRow(dEmpresa.listarRegitrosObject().get(i));
        }
        tblDatos.setModel(modelo);
    }

    public void llenarComboEmpresa(JComboBox<E_Empresa> cboEmpresa) {
        E_Empresa empresa = new E_Empresa();
        D_Empresa dEmpresa = new D_Empresa();
        for (int i = 0; i < dEmpresa.listarRegistros().size(); i++) {
            empresa = dEmpresa.listarRegistros().get(i);
            cboEmpresa.addItem(empresa);
        }

    }

}
