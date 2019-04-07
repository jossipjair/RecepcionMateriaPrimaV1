    package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_Estado;
import Entidad.E_Lote;
import Entidad.E_Sucursal;
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
public class D_Lote implements ICrud<E_Lote> {

    private final String INSERTAR = "INSERT INTO LOTE (idEstado, idSucursal , idVariedad, lote_Descr, lote_NCort) VALUES(?,?,?,?,?)";
    private final String ACTUALIZAR = "UPDATE LOTE SET idSucursal =?, idVariedad = ?, lote_Descr = ?, lote_NCort = ? WHERE idLote = ?";
    private final String DAR_BAJA = "UPDATE LOTE SET idEstado = ? WHERE idLote = ?";
    private final String MOSTRAR = "SELECT lot.idLote, sucu.sucu_Descr, vari.vari_Descr, lot.lote_Descr, lot.lote_NCort, est.esta_Descr FROM LOTE AS lot INNER JOIN ESTADO AS est ON lot.idEstado = est.idEstado INNER JOIN SUCURSAL AS sucu ON sucu.idSucursal = lot.idSucursal INNER JOIN VARIEDAD AS vari ON vari.idVariedad = lot.idVariedad";

    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";

    @Override
    public String insertar(E_Lote c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(INSERTAR);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdSucursal().getIdSucursal());
            pstm.setInt(3, c.getIdVariedad().getIdVariedad());
            pstm.setString(4, c.getLote_Descr());
            pstm.setString(5, c.getLote_NCort());

            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        }
        return mensaje;
    }

    @Override
    public String actualizar(E_Lote c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(ACTUALIZAR);
            pstm.setInt(1, c.getIdSucursal().getIdSucursal());
            pstm.setInt(2, c.getIdVariedad().getIdVariedad());
            pstm.setString(3, c.getLote_Descr());
            pstm.setString(4, c.getLote_NCort());
            pstm.setInt(5, c.getIdLote());

            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public String darBaja(E_Lote c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(DAR_BAJA);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdLote());

            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Inactivo";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public List<E_Lote> listarRegistros() {
        List<E_Lote> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                E_Lote lote = new E_Lote();
                E_Estado estado = new E_Estado();
                E_Sucursal sucursal = new E_Sucursal();
                E_Variedad variedad = new E_Variedad();

                lote.setIdLote(rs.getInt("idLote"));
                sucursal.setSucu_Descr(rs.getString("sucu_Descr"));
                lote.setIdSucursal(sucursal);
                variedad.setVari_Descr(rs.getString("vari_Descr"));
                lote.setIdVariedad(variedad);
                lote.setLote_Descr(rs.getString("lote_Descr"));
                lote.setLote_NCort(rs.getString("lote_NCort"));
                estado.setEsta_Descr(rs.getString("esta_Descr"));
                lote.setIdEstado(estado);
                lista.add(lote);
            }
        } catch (Exception e) {
        }

        return lista;
    }

    @Override
    public List<E_Lote> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        List<Object[]> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                Object variable[] = new Object[6];
                variable[0]  = rs.getInt("idLote");
                variable[1] = rs.getString("sucu_Descr");
                variable[2] = rs.getString("vari_Descr");
                variable[3] = rs.getString("lote_Descr");
                variable[4] = rs.getString("lote_NCort");
                variable[5] = rs.getString("esta_Descr");
               
                lista.add(variable);
            }
        } catch (Exception e) {
        }

        return lista;
    }

}
