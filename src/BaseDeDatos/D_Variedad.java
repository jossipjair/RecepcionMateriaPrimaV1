package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_Cultivo;
import Entidad.E_Estado;
import Entidad.E_Variedad;
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
public class D_Variedad implements ICrud<E_Variedad> {

    private final String INSERTAR = "INSERT INTO VARIEDAD (idCultivo , idEstado, vari_Descr ) VALUES(?,?,?)";
    private final String ACTUALIZAR = "UPDATE VARIEDAD SET idCultivo  =?, vari_Descr  = ? WHERE idVariedad   = ?";
    private final String DAR_BAJA = "UPDATE VARIEDAD SET idEstado = ? WHERE idVariedad = ?";
    private final String MOSTRAR = "SELECT vari.idVariedad, vari.vari_Descr, cult.cult_Descr, est.esta_Descr FROM VARIEDAD AS vari INNER JOIN CULTIVO AS cult ON vari.idCultivo = cult.idCultivo INNER JOIN ESTADO AS est ON est.idEstado = vari.idEstado";

    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";

    @Override
    public String insertar(E_Variedad c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(INSERTAR);
            pstm.setInt(1, c.getIdCultivo().getIdCultivo());
            pstm.setInt(2, c.getIdEstado().getIdEstado());
            pstm.setString(3, c.getVari_Descr());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        }
        return mensaje;
    }

    @Override
    public String actualizar(E_Variedad c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(ACTUALIZAR);
            pstm.setInt(1, c.getIdCultivo().getIdCultivo());
            pstm.setString(2, c.getVari_Descr());
            pstm.setInt(3, c.getIdVariedad());

            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        }
        return mensaje;
    }

    @Override
    public String darBaja(E_Variedad c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(DAR_BAJA);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdVariedad());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro inactivo!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        }
        return mensaje;
    }

    @Override
    public List<E_Variedad> listarRegistros() {
        List<E_Variedad> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                E_Variedad variedad = new E_Variedad();
                E_Estado estado = new E_Estado();
                E_Cultivo cultivo = new E_Cultivo();

                variedad.setIdVariedad(Integer.parseInt(rs.getString("idVariedad")));
                variedad.setVari_Descr(rs.getString("vari_Descr"));
                cultivo.setCult_Descr(rs.getString("cult_Descr"));
                variedad.setIdCultivo(cultivo);
                estado.setEsta_Descr(rs.getString("esta_Descr"));
                variedad.setIdEstado(estado);
                lista.add(variedad);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    @Override
    public List<E_Variedad> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        List<Object[]> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                Object variable[] = new Object[4];
                variable[0] = rs.getString("idVariedad");
                variable[1] = rs.getString("vari_Descr");
                variable[2] = rs.getString("cult_Descr");
                variable[3] = rs.getString("esta_Descr");
                lista.add(variable);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

}
