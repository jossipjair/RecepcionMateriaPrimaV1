package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jescalaya
 *
 * Para TI =D ♥
 *
 */
public class Conexion {

    private static Conexion instancia = null;
    private Connection conexion = null;

    public Conexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //conexion = (Connection) DriverManager.getConnection("jdbc:sqlserver://192.168.2.186:1433;databaseName=ControlRecepcion; user = jossip; password = jossip1234567");
            //conexion = (Connection) DriverManager.getConnection("jdbc:sqlserver://192.168.2.199:1433;databaseName=ControlRecepcion; user = jossip; password = jossip1234567");
            conexion = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ControlRecepcion; user = jescalaya; password = jossip");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Problema con la conexión!\n" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void getDesconectar() {
        try {
            getInstancia().getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
