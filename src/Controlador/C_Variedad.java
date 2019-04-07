
package Controlador;

import BaseDeDatos.D_Variedad;
import Entidad.E_Cultivo;
import Entidad.E_Estado;
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
public class C_Variedad {
     private String mensaje;

    public String insertarVariedad(JTextField txtIdVariedad, JTextField txtDescripcion, int idCultivo, boolean guardar) {
        //CREACION DE OBJETOS
        D_Variedad dVariedad = new D_Variedad();
        E_Variedad eVariedad = new E_Variedad();
        E_Cultivo eCultivo = new E_Cultivo();
        E_Estado eEstado = new E_Estado();

        //ASIGNACION DE VARIABLES A OBJETOS
        
        eVariedad.setIdVariedad(Integer.parseInt(txtIdVariedad.getText()));
        eVariedad.setVari_Descr(txtDescripcion.getText());
        eCultivo.setIdCultivo(idCultivo);
        eVariedad.setIdCultivo(eCultivo);
        eEstado.setIdEstado(1);
        eEstado.setEsta_Descr("ACTIVO");
        eVariedad.setIdEstado(eEstado);

        //INSERSION DE DATOS
        if (guardar) {
            mensaje = dVariedad.insertar(eVariedad);
        } else {
            mensaje = dVariedad.actualizar(eVariedad);
        }
        return mensaje;
    }
    
    public String darBajaVariedad(JTextField txtIdCultivo, JLabel lblEstado) {
        D_Variedad dVariedad = new D_Variedad();
        E_Variedad eVariedad = new E_Variedad();
        E_Estado eEstado = new E_Estado();

        if (lblEstado.getText().equals("ACTIVO")) {
            eEstado.setIdEstado(2); //REGISTRO INACTIVO
            eVariedad.setIdEstado(eEstado);
        } else {
            eEstado.setIdEstado(1); //REGISTRO ACTIVO
            eVariedad.setIdEstado(eEstado);
        }
        return mensaje = dVariedad.darBaja(eVariedad);
    }

    public void mostrarVariedad(JTable tblDatos)
    {
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int indexRow,int indexColumn){
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("VARIEDAD");
        modelo.addColumn("CULTIVO");
        modelo.addColumn("ESTADO");
        D_Variedad dVariedad = new D_Variedad();
        dVariedad.listarRegitrosObject();
    
        for(int i = 0; i < dVariedad.listarRegitrosObject().size(); i++)
        {
            modelo.addRow(dVariedad.listarRegitrosObject().get(i));
        }
        tblDatos.setModel(modelo);
    }
    
       public void llenarComboVariedad(JComboBox<E_Variedad> cboVariedad) {
        D_Variedad dVariedad = new D_Variedad();
        E_Variedad eVariedad = new E_Variedad();
        for (int i = 0; i < dVariedad.listarRegistros().size(); i++) {
            eVariedad = dVariedad.listarRegistros().get(i);
            cboVariedad.addItem(eVariedad);
        }

    }
}
