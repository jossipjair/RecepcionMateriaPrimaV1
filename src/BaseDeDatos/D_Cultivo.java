package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_Cultivo;
import Entidad.E_Estado;
import Interface.ICrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jescalaya
 */
public class D_Cultivo implements ICrud<E_Cultivo> {

    private final String INSERTAR = "INSERT INTO CULTIVO (idEstado, cult_Descr) VALUES(?,?)";
    private final String ACTUALIZAR = "UPDATE CULTIVO SET cult_Descr  =? WHERE idCultivo = ?";
    private final String DAR_BAJA = "UPDATE CULTIVO SET idEstado = ? WHERE idCultivo = ?";
    private final String MOSTRAR = "SELECT cult.idCultivo,  cult.cult_Descr , est.esta_Descr FROM CULTIVO AS cult INNER JOIN ESTADO AS est ON cult.idEstado = est.idEstado";
    //private final String MOSTRAR = "SELECT * FROM CULTIVO";

    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "Sin llamado a método";

    @Override
    public String insertar(E_Cultivo c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(INSERTAR);
            pstm.setInt(1,  c.getIdEstado().getIdEstado());
            pstm.setString(2, c.getCult_Descr());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = "Desde Data: ¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public String actualizar(E_Cultivo c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(ACTUALIZAR);
            pstm.setString(1, c.getCult_Descr());
            pstm.setInt(2, c.getIdCultivo());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = "Desde Data: ¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public String darBaja(E_Cultivo c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(DAR_BAJA);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdCultivo());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro inactivo!";
            }
        } catch (SQLException e) {
            mensaje = "Desde Data: ¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public List<E_Cultivo> listarRegistros() {
        List<E_Cultivo> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);

            while (rs.next()) {
                E_Cultivo cultivo = new E_Cultivo();
                E_Estado estado = new E_Estado();
                cultivo.setIdCultivo(Integer.parseInt(rs.getString("idCultivo")));
                cultivo.setCult_Descr(rs.getString("cult_Descr"));
                estado.setEsta_Descr(rs.getString("esta_Descr"));
                cultivo.setIdEstado(estado);
                lista.add(cultivo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
        return lista;
    }

    @Override
    public List<E_Cultivo> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        List<Object[]> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);

            while (rs.next()) {
                Object variable[] = new Object[3];
                variable[0] = rs.getString("idCultivo");
                variable[1] = rs.getString("cult_Descr");
                variable[2] = rs.getString("esta_Descr");

                lista.add(variable);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
        return lista;
    }
}
