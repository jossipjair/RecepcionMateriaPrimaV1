package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_Estado;
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
public class D_Estado implements ICrud<E_Estado> {

    private final String INSERTAR = "INSERT INTO ESTADO (esta_Descr) VALUES(?)";
    private final String ACTUALIZAR = "UPDATE ESTADO SET esta_Descr =? WHERE idEstado = ?";
    private final String DAR_BAJA = "";
    private final String MOSTRAR = "SELECT est.idEstado, est.esta_Descr FROM ESTADO AS est";

    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";

    @Override
    public String insertar(E_Estado c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(INSERTAR);
            pstm.setString(1, c.getEsta_Descr());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public String actualizar(E_Estado c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(ACTUALIZAR);
            pstm.setString(1, c.getEsta_Descr());
            pstm.setInt(1, c.getIdEstado());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        }
        return mensaje;
    }

    @Override
    public String darBaja(E_Estado c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_Estado> listarRegistros() {
        List<E_Estado> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                E_Estado estado = new E_Estado();
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setEsta_Descr(rs.getString("esta_Descr"));
                lista.add(estado);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public List<E_Estado> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
