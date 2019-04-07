package BaseDeDatos;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jescalaya
 */
public class D_Consultas {

    private final String MOSTRAR_REIMPRESION = "{call spMostrarDataReimprimir(?, ?)}";
    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private CallableStatement cstm;
    private ResultSet rs;

    public List<String[]> llenarTablaReimpresion(String fechaInicio, String fechaFin) {
        List<String[]> lista = new ArrayList<>();
        try {
            pstm = INSTANCIA.getConexion().prepareCall(MOSTRAR_REIMPRESION);
            pstm.setString(1, fechaInicio);
            pstm.setString(2, fechaFin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String variables[] = new String[13];
                variables[0] = rs.getString(1);
                variables[1] = rs.getString(2);
                variables[2] = rs.getString(3);
                variables[3] = rs.getString(4);
                variables[4] = rs.getString(5);
                variables[5] = rs.getString(6);
                variables[6] = rs.getString(7);
                variables[7] = rs.getString(8);
                variables[8] = rs.getString(9);
                variables[9] = rs.getString(10);
                variables[10] = rs.getString(11);
                variables[11] = rs.getString(12);
                variables[12] = rs.getString(13);
                lista.add(variables);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
}
