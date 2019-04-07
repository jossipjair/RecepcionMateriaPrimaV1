package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_VersionSoftware;
import Interface.ICrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jescalaya
 */
public class D_VersionSoftware implements ICrud<E_VersionSoftware> {

    private final String MOSTRAR = "SELECT verSoft_Descr FROM VERSION_SOFTWARE";
    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;

    @Override
    public String insertar(E_VersionSoftware c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(E_VersionSoftware c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String darBaja(E_VersionSoftware c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_VersionSoftware> listarRegistros() {
        List<E_VersionSoftware> lista = new ArrayList<>();

        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                E_VersionSoftware version = new E_VersionSoftware();
                version.setVersionSoftware(rs.getString("verSoft_Descr"));
                lista.add(version);
            }

        } catch (SQLException e) {
        }
        return lista;
    }

    @Override
    public List<E_VersionSoftware> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
