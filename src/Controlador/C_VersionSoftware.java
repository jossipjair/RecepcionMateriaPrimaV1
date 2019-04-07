package Controlador;

import BaseDeDatos.D_VersionSoftware;
import Entidad.E_VersionSoftware;
import javax.swing.JOptionPane;

/**
 *
 * @author jescalaya
 */
public class C_VersionSoftware {

    public String validarVersionActiva(String mostrarVersion) {
        D_VersionSoftware dVersion = new D_VersionSoftware();
        E_VersionSoftware eVersion = new E_VersionSoftware();

        eVersion = dVersion.listarRegistros().get(0);
        if (!eVersion.getVersionSoftware().equals(mostrarVersion)) {
            JOptionPane.showMessageDialog(null, "Existe una nueva versión para el software, por favor actualizarla");
            System.exit(0);
        } else {

            return eVersion.getVersionSoftware();
        }
        return eVersion.getVersionSoftware();
    }

}
