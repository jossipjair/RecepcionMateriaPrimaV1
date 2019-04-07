package Controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author jescalaya
 */
public class C_Controles {

    public boolean mensajeGuardado() {
        boolean estado = false;
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion;
        eleccion = JOptionPane.showOptionDialog(null, "¿Desea guardar registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if(eleccion == JOptionPane.YES_OPTION){
            estado = true;
        }
        return estado;
    }

}
